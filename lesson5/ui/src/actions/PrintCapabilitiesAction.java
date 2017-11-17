package actions;

import api.IAction;
import facade.Hotel;
import utils.Printer;

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