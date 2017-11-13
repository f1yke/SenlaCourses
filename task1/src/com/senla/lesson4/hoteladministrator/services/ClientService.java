package com.senla.lesson4.hoteladministrator.services;

import com.senla.lesson4.hoteladministrator.entities.Capability;
import com.senla.lesson4.hoteladministrator.entities.Client;
import com.senla.lesson4.hoteladministrator.entities.Room;
import com.senla.lesson4.hoteladministrator.repositories.ClientRepository;
import com.senla.lesson4.hoteladministrator.entities.RoomStatus;
import com.senla.lesson4.hoteladministrator.utils.TextWorker;

import java.text.ParseException;
import java.util.*;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService() throws ParseException {
        clientRepository = new ClientRepository();
    }

    public List<Client> getAllClient() {
        return clientRepository.getClients();
    }

    public Client getClient(int id) {
        return clientRepository.getClientById(id);
    }

    public void settleInRoom(Client client, Room room, Date dateOfSettle, Date dateEviction) {
        if (room.getStatus() == RoomStatus.NOT_USED) {
            clientRepository.addClient(client);
            client.setRoomId(room.getId());
            room.addClient(client);
            room.setStatus(RoomStatus.IN_USE);
            room.setDateOfSettle(dateOfSettle);
            room.setDateEviction(dateEviction);
        }
    }

    public void evictFromRoom(int clientId, Room room) {
        clientRepository.getClientById(clientId).setRoomId(null);
        room.setDateEviction(null);
        room.setDateOfSettle(null);
        room.setStatus(RoomStatus.NOT_USED);
    }

    public void setCapability(int clientId, Capability capability) {
        List<Capability> capabilities = clientRepository.getClientById(clientId).getCapabilities();
        capabilities.add(capability);
    }

    public List<Capability> getCapabilities(int clientId) {
        return clientRepository.getClientById(clientId).getCapabilities();
    }

    public void sortClients(Comparator<Client> comparator) {
        Collections.sort(clientRepository.getClients(), comparator);
    }

    public void writeToFile() {
        TextWorker worker = new TextWorker();
        worker.writeToFile(getAllClient(), "D:\\in_clients.txt");
    }
}