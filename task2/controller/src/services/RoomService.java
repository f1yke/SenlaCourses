package services;

import entities.*;
import repositories.RoomRepository;
import entities.RoomStatus;
import utils.TextWorker;

import java.text.ParseException;
import java.util.*;

public class RoomService {
    private RoomRepository roomRepository;

    public RoomService() {
        roomRepository = new RoomRepository();
    }

    public List<Room> getAllRooms() {
        return roomRepository.getRooms();
    }

    public Room getRoom(int id) {
        return roomRepository.getRoomById(id);
    }

    public void changeStatus(int id, RoomStatus roomStatus) {
        roomRepository.getRoomById(id).setStatus(roomStatus);
    }

    public void changePrice(int id, double price) {
        roomRepository.getRoomById(id).setPrice(price);
    }

    public void addRoom(Room room) {
        roomRepository.addRoom(room);
    }

    public int getCountRooms() {
        return roomRepository.getRooms().size();
    }

    public List<Room> getFreeRooms() {
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : roomRepository.getRooms()) {
            if (room != null && room.getStatus() == RoomStatus.NOT_USED) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public Integer getNumOfFreeRooms() {
        Integer count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room != null && room.getStatus() == RoomStatus.NOT_USED) {
                count++;
            }
        }
        return count;
    }

    public String getRoomDetails(int id) {
        return roomRepository.getRoomById(id).toString();
    }

    public void sortRooms(Comparator<Room> comparator) {
        Collections.sort(roomRepository.getRooms(), comparator);
    }

    public Integer getCountClients() {
        Date dateNow = new Date();
        int count = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room.getDateOfSettle() != null && room.getDateEviction() != null) {
                if (room.getDateOfSettle().before(dateNow) && room.getDateEviction().after(dateNow)) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Room> getRoomsByDate(Date date) {
        List<Room> rooms = new ArrayList<>();
        for (Room room : roomRepository.getRooms()) {
            if (room.getStatus() == RoomStatus.NOT_USED) {
                rooms.add(room);
                continue;
            }
            if (date.after(room.getDateEviction())) {
                rooms.add(room);
            }
        }
        return rooms;
    }

    public Integer getCost(Client client, Room room) {
        int result = 0;
        Date date = new Date();
        long difference = date.getTime() - room.getDateOfSettle().getTime();
        int days = (int) (difference / (24 * 60 * 60 * 1000));
        result += days * room.getPrice();
        for (Capability capability : client.getCapabilities()) {
            if (capability != null) {
                result += capability.getPrice();
            }
        }
        return result;
    }

    public void writeToFile() {
        TextWorker worker = new TextWorker();
        worker.writeToFile(getAllRooms(), "D:\\in_rooms.txt");
    }
}