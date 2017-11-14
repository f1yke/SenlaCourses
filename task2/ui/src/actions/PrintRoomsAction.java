package actions;

import api.IAction;
import facade.Hotel;
import utils.Printer;

public class PrintRoomsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        Printer.printArray(hotel.getRooms());
    }
}