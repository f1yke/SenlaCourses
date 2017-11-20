package actions;

import api.IAction;
import facade.Hotel;

public class SortByCapacityAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.sortAllRoomsByCapacity()) {
            System.out.println("Success!");
        } else {
            System.out.println("Sort error!");
        }
    }
}