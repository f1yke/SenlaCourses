package repositories;

import entities.Client;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients;
    private int lastId;
    private static final Logger logger = Logger.getLogger(ClientRepository.class);

    private static ClientRepository clientRepository;

    public static ClientRepository getInstance(String filePath) {
        if (clientRepository == null) {
            clientRepository = new ClientRepository(filePath);
        }
        return clientRepository;
    }

    public ClientRepository(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            clients = (List<Client>) ois.readObject();
            lastId = clients.get(clients.size() - 1).getId();
        } catch (Exception e) {
            logger.error(e.getMessage());
            lastId = -1;
            clients = new ArrayList<>();
        }
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