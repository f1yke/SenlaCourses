package com.senla.hotel.services;

import com.senla.hotel.entities.Capability;
import com.senla.hotel.entities.Client;
import com.senla.hotel.entities.Room;
import com.senla.hotel.entities.RoomStatus;
import com.senla.hotel.repositories.ClientRepository;
import com.senla.hotel.utils.DataWriter;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService() {
        clientRepository = ClientRepository.getInstance();
    }

    public List<Client> getAllClient() {
        return clientRepository.getClients();
    }

    public Client getClient(int id) {
        return clientRepository.getClientById(id);
    }

    public void settleInRoom(Client client, Room room, Date dateOfSettle, Date dateEviction) {
        if (room.getStatus() == RoomStatus.NOT_USED) {
            client.setRoom(room);
            room.setClient(client);
            room.setStatus(RoomStatus.IN_USE);
            room.setDateOfSettle(dateOfSettle);
            room.setDateEviction(dateEviction);
        }
    }

    public void evictFromRoom(Client client, Room room) {
        client.setRoom(null);
        room.setDateEviction(null);
        room.setDateOfSettle(null);
        room.setStatus(RoomStatus.NOT_USED);
    }

    public void addClient(String name) {
        Client client = new Client();
        client.setName(name);
        clientRepository.addClient(client);
    }

    public boolean setCapability(int clientId, Capability capability) {
        Client client = clientRepository.getClientById(clientId);
        if (client != null && capability != null) {
            client.setCapability(capability);
            return true;
        } else {
            return false;
        }
    }

    public List<Capability> getCapabilities(int clientId) {
        List<Capability> capabilities = null;
        Client client = clientRepository.getClientById(clientId);
        if (client != null) {
            capabilities = clientRepository.getClientById(clientId).getCapabilities();
        }
        return capabilities;
    }

    public void sortClients(Comparator<Client> comparator) {
        Collections.sort(clientRepository.getClients(), comparator);
    }

    public void writeToFile(String path) {
        new DataWriter().writeObject(clientRepository.getClients(), path);
    }
}