package repositories;

import com.danco.training.TextFileWorker;
import entities.Client;
import org.apache.log4j.Logger;
import utils.TextWorker;

import java.util.ArrayList;
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

    public ClientRepository() {
        try {
            clients = new TextWorker().getClients(new TextFileWorker("in_clients.txt").readFromFile());
            lastId = clients.get(clients.size() - 1).getId();
        } catch (Exception e) {
            logger.error(e.getMessage());
            lastId = 0;
            clients = new ArrayList<>();
        }
    }

    public void addClient(Client client) {
        client.setId(lastId);
        lastId++;
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
}