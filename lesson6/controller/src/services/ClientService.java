package services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import entities.*;
import repositories.ClientRepository;
import repositories.RoomRepository;

import java.io.*;
import java.util.*;

public class ClientService {
    private ClientRepository clientRepository;
    private RoomRepository roomRepository;

    public ClientService(String pathClient, String pathRoom) {
        clientRepository = ClientRepository.getInstance(pathClient);
        roomRepository = RoomRepository.getInstance(pathRoom);
    }

    public List<Client> getAllClient() {
        return clientRepository.getClients();
    }

    public Client getClient(int id) {
        return clientRepository.getClientById(id);
    }

    public void settleInRoom(Client client, Room room, Date dateOfSettle, Date dateEviction) {
        if (room.getStatus() == RoomStatus.NOT_USED) {
            client.setRoom(room);
            room.addClient(client);
            room.setStatus(RoomStatus.IN_USE);
            room.setDateOfSettle(dateOfSettle);
            room.setDateEviction(dateEviction);
        }
    }

    public void evictFromRoom(Client client, Room room) {
        client.setRoom(null);
        room.setDateEviction(null);
        room.setDateOfSettle(null);
        room.setStatus(RoomStatus.NOT_USED);
    }

    public void addClient(String name) {
        Client client = new Client();
        client.setName(name);
        clientRepository.addClient(client);
    }

    public boolean setCapability(int clientId, Capability capability) {
        Client client = clientRepository.getClientById(clientId);
        if (client != null && capability != null) {
            client.setCapability(capability);
            return true;
        } else {
            return false;
        }
    }

    public List<Capability> getCapabilities(int clientId) {
        List<Capability> capabilities = null;
        Client client = clientRepository.getClientById(clientId);
        if (client != null) {
            capabilities = clientRepository.getClientById(clientId).getCapabilities();
        }
        return capabilities;
    }

    public void sortClients(Comparator<Client> comparator) {
        Collections.sort(clientRepository.getClients(), comparator);
    }

    public void writeToFile(String path) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(clientRepository.getClients());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importCSV(String path) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path));
        String[] record = null;
        record = reader.readNext();
        while ((record = reader.readNext()) != null) {
            Client client = new Client();
            client.setId(Integer.parseInt(record[0]));
            client.setName(record[1]);
            if (record[2] != null) {
                Room room = roomRepository.getRoomById(Integer.parseInt(record[2]));
                if (room != null) {
                    client.setRoom(room);
                }
            }
            if(!clientRepository.updateClient(client)) {
                clientRepository.addClient(client);
            }
        }
        reader.close();
    }

    public void exportCSV() throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter("data.csv"), '#', '\'');
        List<String[]> data = new ArrayList<>();
        data.add(new String[] { "ID", "Name", "RoomID" });
        Iterator<Client> iterator = clientRepository.getClients().iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            data.add(new String[] { String.valueOf(client.getId()), client.getName(), String.valueOf(client.getRoom().getId()) });
        }
        csvWriter.writeAll(data);
        csvWriter.close();
    }
}