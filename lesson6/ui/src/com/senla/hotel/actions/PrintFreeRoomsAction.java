package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import com.senla.hotel.utils.Printer;

public class PrintFreeRoomsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.getFreeRooms() != null) {
            Printer.printArray(hotel.getFreeRooms());
        } else {
            System.out.println("Error!");
        }
    }
}