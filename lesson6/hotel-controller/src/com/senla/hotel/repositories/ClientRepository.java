package com.senla.hotel.repositories;

import com.senla.hotel.entities.Client;
import com.senla.hotel.utils.DataReader;
import org.apache.log4j.Logger;

import java.util.List;

public class ClientRepository {
    private List<Client> clients;
    private int lastId;
    private static final Logger logger = Logger.getLogger(ClientRepository.class);

    private static ClientRepository clientRepository;

    public static ClientRepository getInstance() {
        if (clientRepository == null) {
            clientRepository = new ClientRepository();
        }
        return clientRepository;
    }

    private ClientRepository() {
        PropertyRepository propertyRepository = PropertyRepository.getInstance();
        clients = (List<Client>) new DataReader().readObjects((String) propertyRepository.getProperty("clientPath"));
        lastId = getLastId();
    }

    private Integer getLastId() {
        Integer lastId = -1;
        if (clients.size() > 0) {
            lastId = clients.get(clients.size() - 1).getId();
        }
        return lastId;
    }

    public void addClient(Client client) {
        lastId++;
        client.setId(lastId);
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getClientById(int id) {
        Client client = null;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) {
                client = clients.get(i);
                break;
            }
        }
        return client;
    }

    public boolean updateClient(Client client) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == client.getId()) {
                clients.set(i, client);
                return true;
            }
        }
        return false;
    }
}