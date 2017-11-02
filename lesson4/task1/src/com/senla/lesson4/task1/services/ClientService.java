package com.senla.lesson4.task1.services;

import com.senla.lesson4.task1.entities.Client;
import com.senla.lesson4.task1.entities.Room;
import com.senla.lesson4.task1.repositories.ClientRepository;
import com.senla.lesson4.task1.utils.RoomStatus;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService() {
        clientRepository = new ClientRepository();
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
        return clientRepository.getClients().length;
    }

}