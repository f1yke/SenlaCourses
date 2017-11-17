package facade;

import comparators.rooms.*;
import comparators.clients.*;
import comparators.rooms.PriceComparator;
import entities.*;
import services.*;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    private ClientService clientService;
    private RoomService roomService;
    private CapabilityService capabilityService;
    private RoomHistoryService roomHistoryService;
    private Logger logger = Logger.getLogger(Hotel.class);

    public Hotel() {
        clientService = new ClientService();
        roomService = new RoomService();
        capabilityService = new CapabilityService();
        roomHistoryService = new RoomHistoryService();
    }

    private static Hotel hotel;

    public static Hotel getInstance() {
        if (hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
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
            List<RoomHistory> roomHistories = roomHistoryService.getLastThreeEntry(roomId);
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

    public boolean changeStatus(int roomId, String status) {
        try {
            boolean flag = false;
            if (status == RoomStatus.REPAIR.toString()) {
                flag = roomService.changeStatus(roomId, RoomStatus.REPAIR);
            }
            if (status == RoomStatus.NOT_USED.toString()) {
                flag = roomService.changeStatus(roomId, RoomStatus.NOT_USED);
            }
            return flag;
        } catch (Exception e) {
            logger.error("Error!");
            return false;
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

    public boolean writeToFile() {
        try {
            clientService.writeToFile();
            roomService.writeToFile();
            capabilityService.writeToFile();
            roomHistoryService.writeToFile();
            return true;
        } catch (Exception e) {
            logger.error("Error!");
            return false;
        }
    }
}