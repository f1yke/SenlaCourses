package facade;

import comparators.rooms.*;
import comparators.clients.*;
import entities.*;
import services.*;
import org.apache.log4j.Logger;
import utils.CSVReader;
import utils.CSVWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Hotel {
    private ClientService clientService;
    private RoomService roomService;
    private CapabilityService capabilityService;
    private RoomHistoryService roomHistoryService;
    private Logger logger = Logger.getLogger(Hotel.class);
    private PropertyService propertyService;
    private CSVReader csvReader;
    private CSVWriter csvWriter;
    private Boolean isChangeStatus;
    private Integer countEntry;
    private String roomPath;
    private String clientPath;
    private String capabilityPath;
    private String historyPath;

    public Hotel() {
        propertyService = new PropertyService();
        propertyService.readProperties();
        this.getProperty();
        clientService = new ClientService(clientPath);
        roomService = new RoomService(roomPath);
        capabilityService = new CapabilityService(capabilityPath);
        roomHistoryService = new RoomHistoryService(historyPath);
        csvReader = new CSVReader(roomPath, clientPath, capabilityPath);
        csvWriter = new CSVWriter(roomPath, clientPath, capabilityPath);
    }

    private static Hotel hotel;

    public static Hotel getInstance() {
        if (hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
    }

    public Boolean getIsChangeStatus() {
        return isChangeStatus;
    }

    public List<Room> getRooms() {
        List<Room> rooms = null;
        try {
            rooms = roomService.getAllRooms();
        } catch (Exception e) {
            logger.error("Receive error!");
        }
        return rooms;
    }

    public List<Capability> getCapabilities() {
        List<Capability> capabilities = null;
        try {
            capabilities = capabilityService.getAllCapabilities();

        } catch (Exception e) {
            logger.error("Receive error!");
        }
        return capabilities;
    }

    public boolean sortAllRoomsByPrice() {
        try {
            roomService.sortRooms(new PriceComparator());
            return true;
        } catch (Exception e) {
            logger.error("Sort by price error!");
            return false;
        }
    }

    public boolean sortAllRoomsByCapacity() {
        try {
            roomService.sortRooms(new CapacityComparator());
            return true;
        } catch (Exception e) {
            logger.error("Sort by capacity error!");
            return false;
        }
    }

    public boolean sortAllRoomsByStars() {
        try {
            roomService.sortRooms(new StarsComparator());
            return true;
        } catch (Exception e) {
            logger.error("Sort by stars error!");
            return false;
        }
    }

    public List<Room> getFreeRooms() {
        List<Room> freeRooms = null;
        try {
            freeRooms = roomService.getFreeRooms();
        } catch (Exception e) {
            logger.error("Receive error!");
        }
        return freeRooms;
    }

    public List<Client> getClients() {
        List<Client> clients = null;
        try {
            clients = clientService.getAllClient();
        } catch (Exception e) {
            logger.error("Receive error!");
        }
        return clients;
    }

    public boolean addClient(String name) {
        try {
            clientService.addClient(name);
            return true;
        } catch (Exception e) {
            logger.error("Error adding");
            return false;
        }
    }

    public boolean settleInRoom(int clientId, int roomId, String date1, String date2) {
        Client client = clientService.getClient(clientId);
        Room room = roomService.getRoom(roomId);
        if (client == null || room == null) {
            return false;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date dateOfSettle = format.parse(date1);
            Date dateEviction = format.parse(date2);
            clientService.settleInRoom(client, room, dateOfSettle, dateEviction);
            RoomHistory history = new RoomHistory();
            history.setIdClient(client.getId());
            history.setIdRoom(room.getId());
            history.setDateOfSettle(dateOfSettle);
            history.setDateEviction(dateEviction);
            roomHistoryService.addRoomHistory(history);
            return true;
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean sortClientsByName() {
        try {
            clientService.sortClients(new NameComparator());
            return true;
        } catch (Exception e) {
            logger.error("Sort error!");
            return false;
        }
    }

    public Integer getCountFreeRooms() {
        Integer countFreeRooms = null;
        try {
            countFreeRooms = roomService.getNumOfFreeRooms();
        } catch (Exception e) {
            logger.error("Receive error!");
        }
        return countFreeRooms;
    }

    public Integer getCountClients() {
        Integer countClients = null;
        try {
            countClients = roomService.getCountClients();
        } catch (Exception e) {
            logger.error("Receive error!");
        }
        return countClients;
    }

    public List<Room> getRoomsByDate(String dateString) {
        List<Room> rooms = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(dateString);
            rooms = roomService.getRoomsByDate(date);
        } catch (Exception e) {
            logger.error("Receive error!");
        }
        return rooms;
    }

    public Integer getCost(int clientId) {
        Integer cost = null;
        try {
            Client client = clientService.getClient(clientId);
            if (client == null) {
                return null;
            }
            if (client.getRoom() == null) {
                return null;
            }
            Room room = client.getRoom();
            cost = roomService.getCost(client, room);
        } catch (Exception e) {
            logger.error("Error!");
        }
        return cost;
    }

    public List<String> getLastThreeClients(int roomId) {
        List<String> lastThreeClients = null;
        try {
            lastThreeClients = new ArrayList<>();
            List<RoomHistory> roomHistories = roomHistoryService.getLastThreeEntry(roomId, countEntry);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            for (RoomHistory roomHistory : roomHistories) {
                StringBuilder sb = new StringBuilder();
                if (clientService.getClient(roomHistory.getIdClient()) != null) {
                    sb.append(clientService.getClient(roomHistory.getIdClient()).getName()).append(" ")
                            .append(roomService.getRoom(roomHistory.getIdRoom()).getNumber()).append(" ")
                            .append(format.format(roomHistory.getDateOfSettle())).append(" ")
                            .append(format.format(roomHistory.getDateEviction()));
                    lastThreeClients.add(sb.toString());
                }
            }
        } catch (Exception e) {
            logger.error("Error!");
        }
        return lastThreeClients;
    }

    public List<Capability> getCapabilitiesClient(int clientId) {
        List<Capability> capabilities = null;
        try {
            capabilities = clientService.getCapabilities(clientId);
        } catch (Exception e) {
            logger.error("Error!");
        }
        return capabilities;
    }

    public boolean addCapability(int clientId, int capabilityId) {
        boolean flag = false;
        try {
            flag = clientService.setCapability(clientId, capabilityService.getCapability(capabilityId));
        } catch (Exception e) {
            logger.error("Error!");
        }
        return flag;
    }

    public boolean sortClientCapabilitiesByPrice(int clientId) {
        try {
            Client client = clientService.getClient(clientId);
            if (client != null) {
                capabilityService.sortCapabilities(client.getCapabilities(), new comparators.capabilities.PriceComparator());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Sort by price error!");
            return false;
        }
    }

    public boolean sortAllCapabilitiesByPrice() {
        try {
            capabilityService.sortCapabilities(new comparators.capabilities.PriceComparator());
            return true;
        } catch (Exception e) {
            logger.error("Sort by price error!");
            return false;
        }
    }

    public String getRoomDetails(int roomId) {
        String details = null;
        try {
            details = roomService.getRoomDetails(roomId);
        } catch (Exception e) {
            logger.error("Error!");
        }
        return details;
    }

    public boolean removeClient(int clientId) {
        try {
            Client client = clientService.getClient(clientId);
            if (client == null) {
                return false;
            }
            if (client.getRoom() == null) {
                return false;
            }
            Room room = client.getRoom();
            clientService.evictFromRoom(client, room);
            return true;
        } catch (Exception e) {
            logger.error("Error!");
            return false;
        }
    }

    public Integer changeStatus(int roomId, String status) {
        try {
            Integer flag = 0;
            if (Objects.equals(status, RoomStatus.REPAIR.toString())) {
                flag = roomService.changeStatus(roomId, RoomStatus.REPAIR);
            }
            if (Objects.equals(status, RoomStatus.NOT_USED.toString())) {
                flag = roomService.changeStatus(roomId, RoomStatus.NOT_USED);
            }
            return flag;
        } catch (Exception e) {
            logger.error("Error!");
            return -1;
        }
    }

    public boolean changePrice(int roomId, int price) {
        boolean flag = false;
        try {
            flag = roomService.changePrice(roomId, price);
        } catch (Exception e) {
            logger.error("Error!");
        }
        return flag;
    }

    public boolean changePrice(int capabilityId, Double price) {
        boolean flag = false;
        try {
            flag = capabilityService.changePrice(capabilityId, price);
        } catch (Exception e) {
            logger.error("Error!");
        }
        return flag;
    }

    public boolean addRoom(int number, double price, int capacity, int countStars) {
        try {
            roomService.addRoom(number, price, capacity, countStars);
            return true;
        } catch (Exception e) {
            logger.error("Error adding");
            return false;
        }
    }

    public boolean addCapability(String name, double price) {
        try {
            capabilityService.addCapability(name, price);
            return true;
        } catch (Exception e) {
            logger.error("Error adding");
            return false;
        }
    }

    public void getProperty() {
        try {
            isChangeStatus = Boolean.parseBoolean(String.valueOf(propertyService.getProperty("isChangeStatus")));
            countEntry = Integer.parseInt(String.valueOf(propertyService.getProperty("countEntry")));
            roomPath = String.valueOf(propertyService.getProperty("roomPath"));
            clientPath = String.valueOf(propertyService.getProperty("clientPath"));
            capabilityPath = String.valueOf(propertyService.getProperty("capabilityPath"));
            historyPath = String.valueOf(propertyService.getProperty("historyPath"));
        } catch (Exception e) {
            logger.error("Error");
        }
    }

    public boolean writeToFile() {
        try {
            clientService.writeToFile(clientPath);
            roomService.writeToFile(roomPath);
            capabilityService.writeToFile(capabilityPath);
            roomHistoryService.writeToFile(historyPath);
            return true;
        } catch (Exception e) {
            logger.error("Error!");
            return false;
        }
    }

    public Integer createClone(int id, int number) {
        try {
            Room room = roomService.getRoom(id);
            return roomService.createClone(room, number);
        } catch (Exception e) {
            logger.error("Error");
            return -1;
        }
    }

    public boolean updateRoom(int id, Double price, Integer capacity, Integer countStars, String status) {
        try {
            Room room = roomService.getRoom(id);
            room.setPrice(price);
            room.setCapacity(capacity);
            room.setCountStars(countStars);
            room.setStatus(RoomStatus.valueOf(status));
            return roomService.updateRoom(room);
        } catch (Exception e) {
            logger.error("Error");
            return false;
        }
    }

    public void importClients() {
        try {
            csvReader.importClients("clients.csv");
        } catch (Exception e) {
            logger.error("Error!");
        }
    }

    public void exportClient() {
        try {
            csvWriter.exportClients("clients.csv");
        } catch (Exception e) {
            logger.error("Error!");
        }
    }

    public void importRooms() {
        try {
            csvReader.importRooms("rooms.csv");
        } catch (Exception e) {
            logger.error("Error!");
        }
    }

    public void exportRooms() {
        try {
            csvWriter.exportRooms("rooms.csv");
        } catch (Exception e) {
            logger.error("Error!");
        }
    }

    public void importCapabilities() {
        try {
            csvReader.importCapabilities("capabilities.csv");
        } catch (Exception e) {
            logger.error("Error!");
        }
    }

    public void exportCapabilities() {
        try {
            csvWriter.exportCapabilities("capabilities.csv");
        } catch (Exception e) {
            logger.error("Error!");
        }
    }
}