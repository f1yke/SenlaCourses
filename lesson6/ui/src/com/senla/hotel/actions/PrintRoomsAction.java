package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import com.senla.hotel.utils.Printer;

public class PrintRoomsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.getRooms() != null) {
            Printer.printArray(hotel.getRooms());
        } else {
            System.out.println("Error!");
        }
    }
}