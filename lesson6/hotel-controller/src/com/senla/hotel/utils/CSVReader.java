package com.senla.hotel.utils;

import com.senla.hotel.entities.Capability;
import com.senla.hotel.entities.Client;
import com.senla.hotel.entities.Room;
import com.senla.hotel.entities.RoomStatus;
import com.senla.hotel.repositories.CapabilityRepository;
import com.senla.hotel.repositories.ClientRepository;
import com.senla.hotel.repositories.RoomRepository;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class CSVReader {
    private RoomRepository roomRepository;
    private ClientRepository clientRepository;
    private CapabilityRepository capabilityRepository;
    private Logger logger = Logger.getLogger(CSVReader.class);

    public CSVReader() {
        roomRepository = RoomRepository.getInstance();
        clientRepository = ClientRepository.getInstance();
        capabilityRepository = CapabilityRepository.getInstance();
    }

    public void importRooms(String path) {
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String csvHeader = csvReader.readLine();
            String line;
            while ((line = csvReader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String[] data = line.split(",");
                Room room = new Room();
                room.setId(Integer.parseInt(data[0]));
                room.setNumber(Integer.parseInt(data[1]));
                room.setPrice(Double.parseDouble(data[2]));
                room.setCapacity(Integer.parseInt(data[3]));
                room.setCountStars(Integer.parseInt(data[4]));
                room.setStatus(RoomStatus.valueOf(data[5]));
                if (data.length > 6) {
                    Client client = clientRepository.getClientById(Integer.parseInt(data[8]));
                    if (client != null) {
                        room.setClient(client);
                        client.setRoom(room);
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        room.setDateOfSettle(format.parse(data[6]));
                        room.setDateEviction(format.parse(data[7]));
                    } else {
                        room.setStatus(RoomStatus.NOT_USED);
                    }
                }

                if (!roomRepository.updateRoom(room)) {
                    roomRepository.addRoom(room);
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void importClients(String path) {
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String header = csvReader.readLine();
            String line;
            while ((line = csvReader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String[] data = line.split(",");
                Client client = new Client();
                client.setId(Integer.parseInt(data[0]));
                client.setName(data[1]);
                if (data.length > 2) {
                    Room room = roomRepository.getRoomById(Integer.parseInt(data[2]));
                    if (room != null) {
                        client.setRoom(room);
                        room.setStatus(RoomStatus.IN_USE);
                        room.setClient(client);
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        room.setDateOfSettle(format.parse(data[3]));
                        room.setDateEviction(format.parse(data[4]));
                    }
                }
                if (!clientRepository.updateClient(client)) {
                    clientRepository.addClient(client);
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void importCapabilities(String path) {
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String header = csvReader.readLine();
            String line;
            while ((line = csvReader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                String[] data = line.split(",");
                Capability capability = new Capability();
                capability.setId(Integer.parseInt(data[0]));
                capability.setName(data[1]);
                capability.setPrice(Double.parseDouble(data[2]));
                if (!capabilityRepository.updateCapability(capability)) {
                    capabilityRepository.addCapability(capability);
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }
}