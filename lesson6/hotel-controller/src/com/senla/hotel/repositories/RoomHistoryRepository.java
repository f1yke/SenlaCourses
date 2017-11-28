package com.senla.hotel.repositories;

import com.senla.hotel.entities.RoomHistory;
import com.senla.hotel.utils.DataReader;
import org.apache.log4j.Logger;

import java.util.List;

public class RoomHistoryRepository {
    private List<RoomHistory> roomHistories;
    private Logger logger = Logger.getLogger(RoomHistoryRepository.class);

    private static RoomHistoryRepository roomHistoryRepository;

    public static RoomHistoryRepository getInstance() {
        if (roomHistoryRepository == null) {
            roomHistoryRepository = new RoomHistoryRepository();
        }
        return roomHistoryRepository;
    }

    private RoomHistoryRepository() {
        PropertyRepository propertyRepository = PropertyRepository.getInstance();
        roomHistories = (List<RoomHistory>) new DataReader().readObjects((String) propertyRepository.getProperty("historyPath"));
    }

    public void addHistory(RoomHistory roomHistory) {
        roomHistories.add(roomHistory);
    }

    public List<RoomHistory> getRoomHistories() {
        return roomHistories;
    }
}