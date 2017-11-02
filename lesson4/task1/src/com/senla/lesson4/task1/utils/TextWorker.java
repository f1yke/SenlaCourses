package com.senla.lesson4.task1.utils;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.task1.entities.Capability;
import com.senla.lesson4.task1.entities.Client;
import com.senla.lesson4.task1.entities.Entity;
import com.senla.lesson4.task1.entities.Room;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TextWorker {
    private TextFileWorker textFileWorker;

    public TextWorker() {
        textFileWorker = new TextFileWorker("D:\\out.txt");
    }

    public Room[] getRooms(String[] entities) throws ParseException {
        Room[] rooms = new Room[entities.length];
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room();
            String[] line = entities[i].split(" ");
            rooms[i].setId(Integer.parseInt(line[0]));
            rooms[i].setPrice(Double.parseDouble(line[1]));
            rooms[i].setCapacity(Integer.parseInt(line[2]));
            rooms[i].setCountStars(Integer.parseInt(line[3]));
            rooms[i].setStatus(RoomStatus.valueOf(line[4]));
            if (line.length > 5) {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                rooms[i].setDateOfSettle(format.parse(line[5]));
                rooms[i].setDateEviction(format.parse(line[6]));
            }
        }
        return rooms;
    }

    public Client[] getClients(String[] entities) {
        Client[] clients = new Client[entities.length];
        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Client();
            String[] line = entities[i].split(" ");
            clients[i].setId(Integer.parseInt(line[0]));
            clients[i].setName(line[1]);
        }
        return clients;
    }

    public Capability[] getCapabilities(String[] entities) {
        Capability[] capabilities = new Capability[entities.length];
        for (int i = 0; i < capabilities.length; i++) {
            capabilities[i] = new Capability();
            String[] line = entities[i].split(" ");
            capabilities[i].setId(Integer.parseInt(line[0]));
            capabilities[i].setName(line[1]);
            capabilities[i].setPrice(Double.parseDouble(line[2]));
        }
        return capabilities;
    }

    public void writeToFile(Entity[] entities) {
        String[] objects = new String[entities.length];
        for (int i = 0; i < entities.length; i++) {
            objects[i] = entities[i].toString();
        }
        textFileWorker.writeToFile(objects);
    }
}