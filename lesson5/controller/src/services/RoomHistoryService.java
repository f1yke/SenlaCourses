package services;

import entities.RoomHistory;
import repositories.RoomHistoryRepository;
import utils.TextWorker;

import java.io.File;
import java.io.IOException;
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

    public void writeToFile() throws IOException {
        TextWorker worker = new TextWorker();
        File file = new File("in_histories.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        worker.writeToFile(roomHistoryRepository.getRoomHistories(), file.getPath());
    }
}
