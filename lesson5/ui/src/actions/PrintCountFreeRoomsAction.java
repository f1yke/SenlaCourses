package actions;

import api.IAction;
import facade.Hotel;

public class PrintCountFreeRoomsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.getCountFreeRooms() != null) {
            System.out.println("Count free rooms: " + hotel.getCountFreeRooms());
        } else {
            System.out.println("Error!");
        }
    }
}