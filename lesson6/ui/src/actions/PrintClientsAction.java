package actions;

import api.IAction;
import facade.Hotel;
import utils.Printer;

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