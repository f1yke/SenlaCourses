package com.senla.hotel.services;

import com.senla.hotel.entities.RoomHistory;
import com.senla.hotel.repositories.RoomHistoryRepository;
import com.senla.hotel.utils.DataWriter;

import java.util.ArrayList;
import java.util.List;

public class RoomHistoryService {
    private RoomHistoryRepository roomHistoryRepository;

    public RoomHistoryService() {
        roomHistoryRepository = RoomHistoryRepository.getInstance();
    }

    public void addRoomHistory(RoomHistory history) {
        roomHistoryRepository.addHistory(history);
    }

    public List<RoomHistory> getLastThreeEntry(int roomId, int countEntry) {
        List<RoomHistory> allRoomHistories = new ArrayList<>();
        for (RoomHistory roomHistory : roomHistoryRepository.getRoomHistories()) {
            if (roomHistory != null) {
                if (roomHistory.getIdRoom() == roomId) {
                    allRoomHistories.add(roomHistory);
                }
            }
        }

        List<RoomHistory> lastThreeEntry = new ArrayList<>();
        if (allRoomHistories.size() > countEntry) {
            for (int i = 1; i <= countEntry; i++) {
                lastThreeEntry.add(allRoomHistories.get(allRoomHistories.size() - i));
            }
        } else {
            lastThreeEntry.addAll(0, allRoomHistories);
        }
        return lastThreeEntry;
    }

    public void writeToFile(String path) {
        new DataWriter().writeObject(roomHistoryRepository.getRoomHistories(), path);
    }
}