package com.senla.lesson4.hoteladministrator.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.hoteladministrator.entities.Room;
import com.senla.lesson4.hoteladministrator.utils.TextWorker;

import java.text.ParseException;
import java.util.List;

public class RoomRepository {
    private List<Room> rooms;

    public RoomRepository() throws ParseException {
        rooms = new TextWorker().getRooms(new TextFileWorker("D:\\in_rooms.txt").readFromFile());
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoomById(int id) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId() == id) {
                return rooms.get(i);
            }
        }
        return null;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}