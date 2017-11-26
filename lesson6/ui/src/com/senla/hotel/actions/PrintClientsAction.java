package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import com.senla.hotel.utils.Printer;

public class PrintClientsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.getClients() != null) {
            Printer.printArray(hotel.getClients());
        } else {
            System.out.println("Error!");
        }
    }
}