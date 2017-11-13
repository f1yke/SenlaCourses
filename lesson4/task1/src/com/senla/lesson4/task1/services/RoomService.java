package com.senla.lesson4.task1.services;

import com.senla.lesson4.task1.entities.Entity;
import com.senla.lesson4.task1.entities.Room;
import com.senla.lesson4.task1.repositories.RoomRepository;
import com.senla.lesson4.task1.utils.ArrayWorker;
import com.senla.lesson4.task1.utils.Checker;
import com.senla.lesson4.task1.utils.RoomStatus;
import com.senla.lesson4.task1.comparators.RoomComparators;

import java.text.ParseException;
import java.util.Arrays;

public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(String filePath) throws ParseException {
        roomRepository = new RoomRepository(filePath);
    }

    public Room[] getAllRooms() {
        return roomRepository.getRooms();
    }

    public Room getRoom(int id) {
        return roomRepository.getRoomById(id);
    }

    public void changeStatus(int id, RoomStatus roomStatus) {
        roomRepository.getRoomById(id).setStatus(roomStatus);
    }

    public void changePrice(int id, double price) {
        roomRepository.getRoomById(id).setPrice(price);
    }

    public void addRoom(Room room) {
        if (!Checker.checkLength(roomRepository.getRooms()))
            roomRepository.setRooms(castEntitiesArray(ArrayWorker.resize(roomRepository.getRooms())));
        roomRepository.addRoom(room);
    }

    private Room[] castEntitiesArray(Entity[] entities) {
        Room[] roomArray = Arrays.copyOf(entities, entities.length, Room[].class);
        return roomArray;
    }

    public int getCountRooms() {
        return roomRepository.getRooms().length;
    }

    public Room[] getFreeRooms() {
        Room[] freeRooms = new Room[getNumOfFreeRooms()];
        for (Room room : roomRepository.getRooms()) {
            if (room != null && room.getStatus() == RoomStatus.NOT_USED)
                freeRooms[Checker.getPosition(freeRooms)] = room;
        }
        return freeRooms;
    }

    public Integer getNumOfFreeRooms() {
        Integer count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room != null && room.getStatus() == RoomStatus.NOT_USED)
                count++;
        }
        return count;
    }

    public String getRoomDetails(int id) {
        return roomRepository.getRoomById(id).toString();
    }

    public void sortRoomsByPrice() {
        Arrays.sort(roomRepository.getRooms(), new RoomComparators().getPriceComparator());
    }

    public void sortRoomsByCapacity() {
        Arrays.sort(roomRepository.getRooms(), new RoomComparators().getCapacityComparator());
    }

    public void sortRoomsByStars() {
        Arrays.sort(roomRepository.getRooms(), new RoomComparators().getStarsComparator());
    }
}