package services;

import entities.Capability;
import entities.Client;
import entities.Room;
import repositories.ClientRepository;
import entities.RoomStatus;
import utils.TextWorker;

import java.text.ParseException;
import java.util.*;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService() {
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