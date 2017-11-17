package repositories;

import com.danco.training.TextFileWorker;
import entities.RoomHistory;
import org.apache.log4j.Logger;
import utils.TextWorker;

import java.util.ArrayList;
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

    public RoomHistoryRepository() {
        try {
            roomHistories = new TextWorker().getRoomHistory(new TextFileWorker("in_history.txt").readFromFile());

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
