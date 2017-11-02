package com.senla.lesson4.task1.facade;

import com.senla.lesson4.task1.entities.Capability;
import com.senla.lesson4.task1.entities.Room;
import com.senla.lesson4.task1.services.CapabilityService;
import com.senla.lesson4.task1.services.ClientService;
import com.senla.lesson4.task1.services.RoomService;
import com.senla.lesson4.task1.utils.Printer;
import com.senla.lesson4.task1.utils.RoomStatus;
import com.senla.lesson4.task1.utils.TextWorker;

public class Hotel {
    private ClientService clientService;
    private RoomService roomService;
    private CapabilityService capabilityService;
    private TextWorker textWorker;

    public Hotel () {
        clientService = new ClientService();
        roomService = new RoomService();
        capabilityService = new CapabilityService();
        textWorker = new TextWorker();
    }

    public void run() {

        //System.out.println("ID Price Capacity Stars Status");
        Printer.printArray(roomService.getAllRooms());
        Printer.printArray(clientService.getAllClient());
        Printer.printArray(capabilityService.getAllCapabilities());

        clientService.settleInRoom(0, roomService.getRoom(1));
        Printer.printArray(roomService.getAllRooms());
        Printer.printArray(clientService.getAllClient());

        clientService.evictFromRoom(0, roomService.getRoom(1));
        Printer.printArray(roomService.getAllRooms());

        roomService.changeStatus( 1, RoomStatus.REPAIR);
        Printer.printArray(roomService.getAllRooms());

        roomService.changePrice(1, 20);
        Printer.printArray(roomService.getAllRooms());

        capabilityService.changePrice(1, 5);
        Printer.printArray(capabilityService.getAllCapabilities());

        Room room = new Room();
        room.setId(roomService.getCountRooms());
        room.setPrice(15);
        room.setCapacity(3);
        room.setCountStars(5);
        room.setStatus(RoomStatus.NOT_USED);
        roomService.addRoom(room);
        Printer.printArray(roomService.getAllRooms());

        Capability capability = new Capability();
        capability.setId(capabilityService.countCapabilities());
        capability.setName("phone");
        capability.setPrice(1);
        capabilityService.addCapability(capability);
        Printer.printArray(capabilityService.getAllCapabilities());

        Printer.printLine(roomService.getRoomDetails(2));
        Printer.printLine(roomService.getNumOfFreeRooms().toString());

        roomService.sortRoomsByPrice();
        Printer.printArray(roomService.getAllRooms());
        roomService.sortRoomsByCapacity();
        Printer.printArray(roomService.getAllRooms());
        roomService.sortRoomsByStars();
        Printer.printArray(roomService.getAllRooms());

        Printer.printArray(roomService.getFreeRooms());
    }
}
