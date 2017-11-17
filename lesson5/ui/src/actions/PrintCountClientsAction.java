package actions;

import api.IAction;
import facade.Hotel;

public class PrintCountClientsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.getCountClients() != null) {
            System.out.println("Count clients: " + hotel.getCountClients());
        } else {
            System.out.println("Error!");
        }
    }
}