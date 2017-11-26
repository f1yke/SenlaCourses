package com.senla.hotel.utils;

import com.senla.hotel.entities.Capability;
import com.senla.hotel.entities.Client;
import com.senla.hotel.entities.Room;
import org.apache.log4j.Logger;
import com.senla.hotel.repositories.CapabilityRepository;
import com.senla.hotel.repositories.ClientRepository;
import com.senla.hotel.repositories.RoomRepository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class CSVWriter {
    private RoomRepository roomRepository;
    private ClientRepository clientRepository;
    private CapabilityRepository capabilityRepository;
    private Logger logger = Logger.getLogger(CSVWriter.class);

    public CSVWriter(String roomPath, String clientPath, String capabilityPath) {
        roomRepository = RoomRepository.getInstance(roomPath);
        clientRepository = ClientRepository.getInstance(clientPath);
        capabilityRepository = CapabilityRepository.getInstance(capabilityPath);
    }

    public void exportRooms(String path) throws IOException {
        try (BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            csvWriter.write("ID,Room number,Price,Capacity,Count stars,Status,Date of settle,Date eviction,Client ID\n");
            Iterator<Room> it = roomRepository.getRooms().iterator();
            while (it.hasNext()) {
                Room room = it.next();
                StringBuilder sb = new StringBuilder();
                sb.append(room.getId()).append(",").append(room.getNumber()).append(",").append(room.getPrice()).
                        append(",").append(room.getCapacity()).append(",").append(room.getCountStars()).append(",").append(room.getStatus());
                if (room.getDateEviction() != null && room.getDateOfSettle() != null) {
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    sb.append(",").append(format.format(room.getDateOfSettle())).append(",").append(format.format(room.getDateEviction()));
                }
                Client client = clientRepository.getClientById(room.getClient().getId());
                if (client != null) {
                    sb.append(",").append(client.getId());
                }
                csvWriter.write(sb.toString());
                csvWriter.write("\n");
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void exportClients(String path) throws IOException, ParseException {
        try (BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            csvWriter.write("ID,Name,RoomID\n");
            Iterator<Client> iterator = clientRepository.getClients().iterator();
            while (iterator.hasNext()) {
                Client client = iterator.next();
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(client.getId())).append(",").append(client.getName());
                Room room = client.getRoom();
                if (room != null) {
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    sb.append(",").append(room.getId()).append(",").append(format.format(room.getDateOfSettle())).append(",").append(format.format(room.getDateEviction()));
                }
                csvWriter.write(sb.toString());
                csvWriter.write('\n');
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void exportCapabilities(String path) throws IOException {
        try (BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            csvWriter.write("ID,Name,Price\n");
            Iterator<Capability> it = capabilityRepository.getCapabilities().iterator();
            while (it.hasNext()) {
                Capability capability = it.next();
                StringBuilder sb = new StringBuilder();
                sb.append(capability.getId()).append(",").append(capability.getName()).append(",").append(capability.getPrice());
                csvWriter.write(sb.toString());
                csvWriter.write("\n");
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }
}