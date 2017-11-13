package com.senla.lesson4.hoteladministrator.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.hoteladministrator.entities.Client;
import com.senla.lesson4.hoteladministrator.utils.TextWorker;

import java.text.ParseException;
import java.util.List;

public class ClientRepository {
    private List<Client> clients;

    public ClientRepository() throws ParseException {
        clients = new TextWorker().getClients(new TextFileWorker("D:\\in_clients.txt").readFromFile());
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }
    
    public Client getClientById(int id) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) {
                return clients.get(i);
            }
        }
        return null;
    }
}