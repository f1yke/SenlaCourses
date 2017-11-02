package com.senla.lesson4.task1.services;

import com.senla.lesson4.task1.entities.Capability;
import com.senla.lesson4.task1.entities.Client;
import com.senla.lesson4.task1.entities.Entity;
import com.senla.lesson4.task1.entities.Room;
import com.senla.lesson4.task1.repositories.ClientRepository;
import com.senla.lesson4.task1.utils.ArrayWorker;
import com.senla.lesson4.task1.utils.Checker;
import com.senla.lesson4.task1.utils.RoomStatus;

import java.util.Arrays;
import java.util.Date;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(String filePath) {
        clientRepository = new ClientRepository(filePath);
    }

    public Client[] getAllClient() {
        return clientRepository.getClients();
    }

    public Client getClient(int id) {
        return clientRepository.getClientById(id);
    }

    public void settleInRoom(int clientId, Room room) {
        if (room.getStatus() == RoomStatus.NOT_USED) {
            clientRepository.getClientById(clientId).setRoom(room);
            room.setStatus(RoomStatus.IN_USE);
        }
    }

    public void evictFromRoom(int clientId, Room room) {
        clientRepository.getClientById(clientId).setRoom(null);
        room.setStatus(RoomStatus.NOT_USED);
    }

    public Integer getCountClients() {
        int count = 0;
        for (Client client : clientRepository.getClients())
            if (client.getRoom() != null)
                count++;
        return count;
    }

    public void setCapability(int clientId, Capability capability) {
        Capability[] capabilities = clientRepository.getClientById(clientId).getCapabilities();
        if (!Checker.checkLength(capabilities))
            capabilities = castEntitiesArray(ArrayWorker.resize(capabilities));
        capabilities[Checker.getPosition(capabilities)] = capability;
    }

    public Capability[] getCapabilities(int clientId) {
        return clientRepository.getClientById(clientId).getCapabilities();
    }

    private Capability[] castEntitiesArray(Entity[] entities) {
        Capability[] capabilityArray = Arrays.copyOf(entities, entities.length, Capability[].class);
        return capabilityArray;
    }
}