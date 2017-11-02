package com.senla.lesson4.task1.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.task1.entities.Client;
import com.senla.lesson4.task1.utils.TextWorker;

public class ClientRepository {
    private Client[] clients;

    public ClientRepository() {
        clients = new TextWorker().getClients(new TextFileWorker("D:\\in_clients.txt").readFromFile());
    }

    public Client[] getClients() {
        return clients;
    }

    public Client getClientById(int id) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getId() == id)
                return clients[i];
        }
        return null;
    }
}