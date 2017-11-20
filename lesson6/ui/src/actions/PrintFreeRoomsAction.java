package actions;

import api.IAction;
import facade.Hotel;
import utils.Printer;

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