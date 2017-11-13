package com.senla.lesson4.hoteladministrator.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.hoteladministrator.entities.RoomHistory;
import com.senla.lesson4.hoteladministrator.utils.TextWorker;

import java.text.ParseException;
import java.util.List;

public class RoomHistoryRepository {
    private List<RoomHistory> roomHistories;

    public RoomHistoryRepository() throws ParseException {
        roomHistories = new TextWorker().getRoomHistory(new TextFileWorker("D:\\in_history.txt").readFromFile());
    }

    public void addHistory(RoomHistory roomHistory) {
        roomHistories.add(roomHistory);
    }

    public List<RoomHistory> getRoomHistories() {
        return roomHistories;
    }
}
