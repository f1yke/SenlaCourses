package repositories;

import com.danco.training.TextFileWorker;
import entities.Client;
import utils.TextWorker;

import java.text.ParseException;
import java.util.List;

public class ClientRepository {
    private List<Client> clients;

    public ClientRepository() {
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