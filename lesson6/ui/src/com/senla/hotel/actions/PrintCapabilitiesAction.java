package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import com.senla.hotel.utils.Printer;

public class PrintCapabilitiesAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.getCapabilities() != null) {
            Printer.printArray(hotel.getCapabilities());
        } else {
            System.out.println("Error!");
        }
    }
}