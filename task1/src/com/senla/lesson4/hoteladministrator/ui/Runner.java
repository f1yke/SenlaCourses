package com.senla.lesson4.hoteladministrator.ui;

import com.senla.lesson4.hoteladministrator.facade.Hotel;

import java.text.ParseException;

public class Runner {
    public static void main(String[] args) throws ParseException {
        Hotel hotel = new Hotel();

        /*//task_1_1
        hotel.printRooms();
        hotel.sortRoomsByPrice();
        hotel.sortRoomsByCapacity();
        hotel.sortRoomsByStars();
        */

        /*//task_1_2
        hotel.printFreeRooms();
        hotel.sortFreeRoomsByPrice();
        hotel.sortFreeRoomsByCapacity();
        hotel.sortFreeRoomsByStars();
        */

        /*//task1_3
        hotel.printAllClients();
        hotel.sortClientsByName();
        hotel.printRooms();
        */

        /*//task1_4
        hotel.getCountFreeRooms();
        */

        /*//task1_5
        hotel.getCountClients();
        */

        /*//task1_6
        hotel.printRoomsByDate("19-11-2017");
        */

        //task1_7
        /*hotel.printAllClients();
        hotel.printRooms();
        hotel.getCost(1);
        */

        /*//task1_8
        hotel.addClient("Kane", 2, "28-10-2017", "30-10-2017");
        hotel.addClient("Roby", 2, "01-11-2017", "03-11-2017");
        hotel.addClient("George", 2, "05-11-2017", "07-11-2017");
        hotel.addClient("Andrey", 2, "08-11-2017", "09-11-2017");
        hotel.printAllClients();
        hotel.printLastThreeClients(2);
        */

        /*//task1_9
        hotel.printAllClients();
        hotel.addCapability(2, 2);
        hotel.addCapability(2, 1);
        hotel.addCapability(2, 0);

        hotel.sortCapabilitiesByPrice(2);
        hotel.printCapability(2);
        */

        /*//task1_10
        hotel.sortCapabilities();
        hotel.printAllCapabilities();

        hotel.sortAllRoomsByPrice();
        hotel.printRooms();
        */

        /*//task1_11
        hotel.printDetails(2);
        */

        /*//task2_1
        hotel.addClient("Tom",4, "11-11-2017", "14-11-2017");
        hotel.addClient("John",2, "10-11-2017", "17-11-2017");
        hotel.addClient("Andy",5, "14-11-2017", "20-11-2017");
        */

        /*//task2_2
        hotel.removeClient(2);
        hotel.printRooms();
        hotel.printAllClients();
        */

        /*//task2_3
        hotel.printRooms();
        hotel.changeStatus(1, RoomStatus.REPAIR);
        hotel.printRooms();
        */

        /*//task2_4_1
        hotel.printRooms();
        hotel.changePrice(0, 13);
        hotel.printRooms();
        */

        /*//task2_4_2
        hotel.printAllCapabilities();
        hotel.changePrice(1, 6.0);
        hotel.printAllCapabilities();
        */

        //task2_5_1
        /*hotel.printRooms();
        hotel.addRoom(15,2,5,RoomStatus.NOT_USED);
        hotel.printRooms();
        */

        /*//task2_5_2
        hotel.printAllCapabilities();
        hotel.addCapability("new_capability", 7.0);
        hotel.printAllCapabilities();
        */

        //hotel.writeToFile();
    }
}