package actions;

import api.IAction;
import facade.Hotel;
import utils.Printer;

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