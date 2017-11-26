package repositories;

import entities.Room;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private List<Room> rooms;
    private int lastId;
    private Logger logger = Logger.getLogger(RoomRepository.class);

    private static RoomRepository roomRepository;

    public static RoomRepository getInstance(String filePath) {
        if (roomRepository == null) {
            roomRepository = new RoomRepository(filePath);
        }
        return roomRepository;
    }

    public RoomRepository(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            rooms = (List<Room>) ois.readObject();
            lastId = rooms.get(rooms.size() - 1).getId();
        } catch (Exception e) {
            logger.error(e.getMessage());
            lastId = -1;
            rooms = new ArrayList<>();
        }
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