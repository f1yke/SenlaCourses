package com.senla.hotel.repositories;

import com.senla.hotel.entities.RoomHistory;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RoomHistoryRepository {
    private List<RoomHistory> roomHistories;
    private Logger logger = Logger.getLogger(RoomHistoryRepository.class);

    private static RoomHistoryRepository roomHistoryRepository;

    public static RoomHistoryRepository getInstance(String filePath) {
        if (roomHistoryRepository == null) {
            roomHistoryRepository = new RoomHistoryRepository(filePath);
        }
        return roomHistoryRepository;
    }

    public RoomHistoryRepository(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            roomHistories = (List<RoomHistory>) ois.readObject();
        } catch (Exception e) {
            logger.error(e.getMessage());
            roomHistories = new ArrayList<>();
        }
    }

    public void addHistory(RoomHistory roomHistory) {
        roomHistories.add(roomHistory);
    }

    public List<RoomHistory> getRoomHistories() {
        return roomHistories;
    }
}