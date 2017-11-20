package services;

import entities.RoomHistory;
import repositories.RoomHistoryRepository;
import utils.TextWorker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomHistoryService {
    private RoomHistoryRepository roomHistoryRepository;

    public RoomHistoryService(String path) {
        roomHistoryRepository = RoomHistoryRepository.getInstance(path);
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

    public void writeToFile(String path) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(roomHistoryRepository.getRoomHistories());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
