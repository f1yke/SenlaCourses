package facade;

import comparators.*;
import entities.*;
import services.*;
import utils.*;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Hotel {
    private ClientService clientService;
    private RoomService roomService;
    private CapabilityService capabilityService;
    private RoomHistoryService roomHistoryService;
    private TextWorker textWorker;
    private Logger logger = Logger.getLogger(TextWorker.class.getName());

    public Hotel() {
        clientService = new ClientService();
        roomService = new RoomService();
        capabilityService = new CapabilityService();
        roomHistoryService = new RoomHistoryService();
        textWorker = new TextWorker();
    }

    private static Hotel hotel;

    public static Hotel getInstance() {
        if (hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
    }

    public List<Room> getRooms() {
        return roomService.getAllRooms();
    }

    public void sortAllRoomsByPrice() {
        roomService.sortRooms(new RoomComparators().getPriceComparator());
    }

    public void sortAllRoomsByCapacity() {
        roomService.sortRooms(new RoomComparators().getCapacityComparator());
        Printer.printArray(roomService.getAllRooms());
    }

    public void sortAllRoomsByStars() {
        roomService.sortRooms(new RoomComparators().getStarsComparator());
        Printer.printArray(roomService.getAllRooms());
    }

    public void printFreeRooms() {
        Printer.printArray(roomService.getFreeRooms());
    }

    public void sortFreeRoomsByPrice() {
        roomService.sortRooms(new RoomComparators().getPriceComparator());
        Printer.printArray(roomService.getFreeRooms());
    }

    public void sortFreeRoomsByCapacity() {
        roomService.sortRooms(new RoomComparators().getCapacityComparator());
        Printer.printArray(roomService.getFreeRooms());
    }

    public void sortFreeRoomsByStars() {
        roomService.sortRooms(new RoomComparators().getStarsComparator());
        Printer.printArray(roomService.getFreeRooms());
    }

    public List<Client> getAllClients() {
        return clientService.getAllClient();
    }

    public void addClient(String name, Integer roomId, String date1, String date2) throws ParseException {
        try {
            Client client = new Client();
            client.setName(name);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date dateSettle = format.parse(date1);
            Date dateEviction = format.parse(date2);
            clientService.settleInRoom(client, roomService.getRoom(roomId), dateSettle, dateEviction);
            RoomHistory roomHistory = new RoomHistory();
            roomHistory.setIdClient(client.getId());
            roomHistory.setIdRoom(roomId);
            roomHistory.setDateOfSettle(dateSettle);
            roomHistory.setDateEviction(dateEviction);
            roomHistoryService.addRoomHistory(roomHistory);
        } catch (Exception e) {
            logger.info(new Date() + " " + e.getMessage());
        }
    }

    public void sortClientsByName() {
        clientService.sortClients(new ClientComparator().getNameComparator());
        Printer.printArray(clientService.getAllClient());
    }

    public void getCountFreeRooms() {
        Printer.printLine(roomService.getNumOfFreeRooms().toString());
    }

    public void getCountClients() {
        Printer.printLine(roomService.getCountClients().toString());
    }

    public void printRoomsByDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(dateString);
        Printer.printArray(roomService.getRoomsByDate(date));
    }

    public void getCost(int clientId) {
        Client client = clientService.getClient(clientId);
        Room room = roomService.getRoom(client.getRoomId());
        Printer.printLine(roomService.getCost(client, room).toString());
    }

    public void printLastThreeClients(int idRoom) {
        List<RoomHistory> roomHistories = roomHistoryService.getLastThreeEntry(idRoom);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        for (RoomHistory roomHistory : roomHistories) {
            StringBuilder sb = new StringBuilder();
            if (clientService.getClient(roomHistory.getIdClient()) != null) {
                sb.append(clientService.getClient(roomHistory.getIdClient()).getName()).append(" ")
                        .append(roomService.getRoom(roomHistory.getIdRoom()).getNumber()).append(" ")
                        .append(format.format(roomHistory.getDateOfSettle())).append(" ")
                        .append(format.format(roomHistory.getDateEviction()));
                Printer.printLine(sb.toString());
            }
        }
    }

    public void printCapability(int clientId) {
        Printer.printLine(clientService.getClient(clientId).getName() + ":");
        Printer.printArray(clientService.getCapabilities(clientId));
    }

    public void addCapability(int clientId, int capabilityId) {
        clientService.setCapability(clientId, capabilityService.getCapability(capabilityId));
    }

    public void sortCapabilitiesByPrice(int clientId) {
        capabilityService.sortCapabilities(clientService.getCapabilities(clientId), new CapabilityComparator().getCapabilityByPriceComparator());
    }

    public void printAllCapabilities() {
        Printer.printArray(capabilityService.getAllCapabilities());
    }

    public void sortCapabilities() {
        capabilityService.sortCapabilities(new CapabilityComparator().getCapabilityByPriceComparator());
    }

    public void printDetails(int roomId) {
        Printer.printLine(roomService.getRoomDetails(roomId));
    }

    public void removeClient(int clientId) {
        clientService.evictFromRoom(clientId, roomService.getRoom(clientService.getClient(clientId).getRoomId()));
    }

    public void changeStatus(int roomId, RoomStatus status) {
        roomService.changeStatus(roomId, status);
    }

    public void changePrice(int roomId, int price) {
        roomService.changePrice(roomId, price);
    }

    public void changePrice(int capabilityId, Double price) {
        capabilityService.changePrice(capabilityId, price);
    }

    public void addRoom(int price, int capacity, int countStars, RoomStatus status) {
        Room room = new Room();
        room.setPrice(price);
        room.setCapacity(capacity);
        room.setCountStars(countStars);
        room.setStatus(status);
        roomService.addRoom(room);
    }

    public void addCapability(String name, double price) {
        Capability capability = new Capability();
        capability.setName(name);
        capability.setPrice(price);
        capabilityService.addCapability(capability);
    }

    public void writeToFile() {
        clientService.writeToFile();
        roomService.writeToFile();
        capabilityService.writeToFile();
        roomHistoryService.writeToFile();
    }
}