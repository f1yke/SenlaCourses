package com.senla.lesson4.hoteladministrator.services;

import com.senla.lesson4.hoteladministrator.entities.RoomHistory;
import com.senla.lesson4.hoteladministrator.repositories.RoomHistoryRepository;
import com.senla.lesson4.hoteladministrator.utils.TextWorker;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RoomHistoryService {
    private RoomHistoryRepository roomHistoryRepository;

    public RoomHistoryService() throws ParseException {
        roomHistoryRepository = new RoomHistoryRepository();
    }

    public void addRoomHistory(RoomHistory history) {
        roomHistoryRepository.addHistory(history);
    }

    public List<RoomHistory> getLastThreeEntry(int roomId) {
        List<RoomHistory> allRoomHistories = new ArrayList<>();
        for (RoomHistory roomHistory : roomHistoryRepository.getRoomHistories()) {
            if (roomHistory != null) {
                if (roomHistory.getIdRoom() == roomId) {
                    allRoomHistories.add(roomHistory);
                }
            }
        }

        List<RoomHistory> lastThreeEntry = new ArrayList<>();

        if (allRoomHistories.size() > 3) {
            lastThreeEntry.add(allRoomHistories.get(allRoomHistories.size() - 1));
            lastThreeEntry.add(allRoomHistories.get(allRoomHistories.size() - 2));
            lastThreeEntry.add(allRoomHistories.get(allRoomHistories.size() - 3));
        } else {
            lastThreeEntry.addAll(0, allRoomHistories);
        }
        return lastThreeEntry;
    }

    public void writeToFile() {
        TextWorker worker = new TextWorker();
        worker.writeToFile(roomHistoryRepository.getRoomHistories(), "D:\\in_history.txt");
    }
}
