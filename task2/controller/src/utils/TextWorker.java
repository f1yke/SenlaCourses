package utils;

import com.danco.training.TextFileWorker;
import entities.*;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextWorker {
    private TextFileWorker textFileWorker;
    private Logger logger = Logger.getLogger(TextWorker.class.getName());

    public List<Room> getRooms(String[] entities) {
        List<Room> rooms = new ArrayList<>();
        try {
            for (int i = 0; i < entities.length; i++) {
                Room room = new Room();
                String[] line = entities[i].split(" ");
                room.setNumber(Integer.parseInt(line[0]));
                room.setPrice(Double.parseDouble(line[1]));
                room.setCapacity(Integer.parseInt(line[2]));
                room.setCountStars(Integer.parseInt(line[3]));
                room.setStatus(RoomStatus.valueOf(line[4]));
                if (line.length > 5) {
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    room.setDateOfSettle(format.parse(line[5]));
                    room.setDateEviction(format.parse(line[6]));
                }
                rooms.add(room);
            }
        } catch (Exception e) {
            logger.info(new Date() + " " + e.getMessage());
        }
        return rooms;
    }

    public List<Client> getClients(String[] entities) {
        List<Client> clients = new ArrayList<>();
        try {
            for (int i = 0; i < entities.length; i++) {
                Client client = new Client();
                String[] line = entities[i].split(" ");
                client.setName(line[0]);
                client.setRoomId(Integer.parseInt(line[1]));
                clients.add(client);
            }
        } catch (Exception e) {
            logger.info(new Date() + " " + e.getMessage());
        }
        return clients;
    }

    public List<Capability> getCapabilities(String[] entities) {
        List<Capability> capabilities = new ArrayList<>();
        try {
            for (int i = 0; i < entities.length; i++) {
                Capability capability = new Capability();
                String[] line = entities[i].split(" ");
                capability.setId(Integer.parseInt(line[0]));
                capability.setName(line[1]);
                capability.setPrice(Double.parseDouble(line[2]));
                capabilities.add(capability);
            }
        } catch (Exception e) {
            logger.info(new Date() + " " + e.getMessage());
        }
        return capabilities;
    }

    public List<RoomHistory> getRoomHistory(String[] entities) {
        List<RoomHistory> roomHistories = new ArrayList<>();
        try {
            for (int i = 0; i < entities.length; i++) {
                RoomHistory roomHistory = new RoomHistory();
                String[] line = entities[i].split(" ");
                roomHistory.setIdClient(Integer.parseInt(line[0]));
                roomHistory.setIdRoom(Integer.parseInt(line[1]));
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                roomHistory.setDateOfSettle(format.parse(line[2]));
                roomHistory.setDateEviction(format.parse(line[3]));
                roomHistories.add(roomHistory);
            }
        } catch (Exception e) {
            logger.info(new Date() + " " + e.getMessage());
        }
        return roomHistories;
    }

    public void writeToFile(List<? extends Entity> entities, String path) {
        try {
            textFileWorker = new TextFileWorker(path);
            List<String> objects = new ArrayList<>();
            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i) != null) {
                    objects.add(entities.get(i).toString());
                }
            }
            textFileWorker.writeToFile(objects.toArray(new String[objects.size()]));
        } catch (Exception e) {
            logger.info(new Date() + " " + e.getMessage());
        }
    }
}