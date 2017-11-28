package com.senla.hotel.repositories;

import com.senla.hotel.entities.Room;
import com.senla.hotel.utils.DataReader;

import java.util.List;

public class RoomRepository {
    private List<Room> rooms;
    private int lastId;

    private static RoomRepository roomRepository;

    public static RoomRepository getInstance() {
        if (roomRepository == null) {
            roomRepository = new RoomRepository();
        }
        return roomRepository;
    }

    private RoomRepository() {
        PropertyRepository propertyRepository = PropertyRepository.getInstance();
        rooms = (List<Room>) new DataReader().readObjects((String) propertyRepository.getProperty("roomPath"));
        lastId = getLastId();
    }

    private Integer getLastId() {
        Integer lastId = -1;
        if (rooms.size() > 0) {
            lastId = rooms.get(rooms.size() - 1).getId();
        }
        return lastId;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoomById(int id) {
        Room room = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId() == id) {
                room = rooms.get(i);
                break;
            }
        }
        return room;
    }

    public void addRoom(Room room) {
        lastId++;
        room.setId(lastId);
        rooms.add(room);
    }

    public boolean updateRoom(Room room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId() == room.getId()) {
                rooms.set(i, room);
                return true;
            }
        }
        return false;
    }
}