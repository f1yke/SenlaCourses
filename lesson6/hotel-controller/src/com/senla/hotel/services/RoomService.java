package com.senla.hotel.services;

import com.senla.hotel.entities.Capability;
import com.senla.hotel.entities.Client;
import com.senla.hotel.entities.Room;
import com.senla.hotel.entities.RoomStatus;
import com.senla.hotel.repositories.RoomRepository;
import com.senla.hotel.utils.DataWriter;

import java.util.*;

public class RoomService {
    private RoomRepository roomRepository;

    public RoomService() {
        roomRepository = RoomRepository.getInstance();
    }

    public List<Room> getAllRooms() {
        return roomRepository.getRooms();
    }

    public Room getRoom(int id) {
        return roomRepository.getRoomById(id);
    }

    public Integer changeStatus(int id, RoomStatus roomStatus) {
        Room room = roomRepository.getRoomById(id);
        if (room != null) {
            room.setStatus(roomStatus);
            room.setDateOfSettle(null);
            room.setDateEviction(null);
            Client client = room.getClient();
            if (client != null) {
                client.setRoom(null);
            }
            return 1;
        } else {
            return -1;
        }
    }

    public boolean changePrice(int id, double price) {
        Room room = roomRepository.getRoomById(id);
        if (room != null) {
            room.setPrice(price);
            return true;
        } else {
            return false;
        }
    }

    public void addRoom(int number, double price, int capacity, int countStars) {
        Room room = new Room();
        room.setNumber(number);
        room.setPrice(price);
        room.setCapacity(capacity);
        room.setCountStars(countStars);
        roomRepository.addRoom(room);
    }

    public Integer createClone(Room room, int number) throws CloneNotSupportedException {
        Room newRoom = room.clone();
        newRoom.setNumber(number);
        roomRepository.addRoom(newRoom);
        return newRoom.getId();
    }

    public int getCountRooms() {
        return roomRepository.getRooms().size();
    }

    public List<Room> getFreeRooms() {
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : roomRepository.getRooms()) {
            if (room != null && room.getStatus() == RoomStatus.NOT_USED) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public Integer getNumOfFreeRooms() {
        Integer count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room != null && room.getStatus() == RoomStatus.NOT_USED) {
                count++;
            }
        }
        return count;
    }

    public String getRoomDetails(int id) {
        Room room = roomRepository.getRoomById(id);
        return room.toString();
    }

    public void sortRooms(Comparator<Room> comparator) {
        Collections.sort(roomRepository.getRooms(), comparator);
    }

    public Integer getCountClients() {
        Date dateNow = new Date();
        int count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room.getDateOfSettle() != null && room.getDateEviction() != null) {
                if (room.getDateOfSettle().before(dateNow) && room.getDateEviction().after(dateNow)) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Room> getRoomsByDate(Date date) {
        List<Room> rooms = new ArrayList<>();
        for (Room room : roomRepository.getRooms()) {
            if (room.getStatus() == RoomStatus.NOT_USED) {
                rooms.add(room);
                continue;
            }
            if (date.after(room.getDateEviction())) {
                rooms.add(room);
            }
        }
        return rooms;
    }

    public Integer getCost(Client client, Room room) {
        int result = 0;
        Date date = new Date();
        long difference = date.getTime() - room.getDateOfSettle().getTime();
        int days = (int) (difference / (24 * 60 * 60 * 1000));
        result += days * room.getPrice();
        for (Capability capability : client.getCapabilities()) {
            if (capability != null) {
                result += capability.getPrice();
            }
        }
        return result;
    }

    public boolean updateRoom(Room room) {
        return roomRepository.updateRoom(room);
    }

    public void writeToFile(String path) {
        new DataWriter().writeObject(roomRepository.getRooms(), path);
    }
}