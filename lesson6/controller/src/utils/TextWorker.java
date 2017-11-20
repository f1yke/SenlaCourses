package utils;

import com.danco.training.TextFileWorker;
import entities.*;
import repositories.RoomRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TextWorker {
    private TextFileWorker textFileWorker;

    public List<Room> getRooms(String[] entities) throws ParseException {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < entities.length; i++) {
            Room room = new Room();
            String[] line = entities[i].split(" ");
            room.setId(Integer.parseInt(line[0]));
            room.setNumber(Integer.parseInt(line[1]));
            room.setPrice(Double.parseDouble(line[2]));
            room.setCapacity(Integer.parseInt(line[3]));
            room.setCountStars(Integer.parseInt(line[4]));
            room.setStatus(RoomStatus.valueOf(line[5]));
            if (line.length > 5) {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                room.setDateOfSettle(format.parse(line[6]));
                room.setDateEviction(format.parse(line[7]));
            }
            rooms.add(room);
        }
        return rooms;
    }

    public List<Client> getClients(String[] entities) {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < entities.length; i++) {
            Client client = new Client();
            String[] line = entities[i].split(" ");
            client.setId(Integer.parseInt(line[0]));
            client.setName(line[1]);

            if (line[2] != null) {
                //RoomRepository roomRepository = RoomRepository.getInstance();
                //Room room = roomRepository.getRoomById(Integer.parseInt(line[2]));
                //client.setRoom(room);
                //room.addClient(client);
            }
            clients.add(client);
        }
        return clients;
    }

    public List<Capability> getCapabilities(String[] entities) {
        List<Capability> capabilities = new ArrayList<>();
        for (int i = 0; i < entities.length; i++) {
            Capability capability = new Capability();
            String[] line = entities[i].split(" ");
            capability.setId(Integer.parseInt(line[0]));
            capability.setName(line[1]);
            capability.setPrice(Double.parseDouble(line[2]));
            capabilities.add(capability);
        }
        return capabilities;
    }

    public List<RoomHistory> getRoomHistory(String[] entities) throws ParseException {
        List<RoomHistory> roomHistories = new ArrayList<>();
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
        return roomHistories;
    }

    public void writeToFile(List<? extends Entity> entities, String path) {
        textFileWorker = new TextFileWorker(path);
        List<String> objects = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) != null) {
                objects.add(entities.get(i).toString());
            }
        }
        textFileWorker.writeToFile(objects.toArray(new String[objects.size()]));
    }
}