package com.senla.lesson4.task1.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.task1.entities.Room;
import com.senla.lesson4.task1.utils.Checker;
import com.senla.lesson4.task1.utils.TextWorker;

import java.text.ParseException;

public class RoomRepository {
    private Room[] rooms;

    public RoomRepository(String filePath) throws ParseException {
        rooms = new TextWorker().getRooms(new TextFileWorker(filePath).readFromFile());
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room getRoomById(int id) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getId() == id)
                return rooms[i];
        }
        return null;
    }

    public void addRoom(Room room) {
        rooms[Checker.getPosition(rooms)] = room;
    }
}