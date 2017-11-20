package actions;

import api.IAction;
import facade.Hotel;

public class SortByPriceAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.sortAllRoomsByPrice()) {
            System.out.println("Success!");
        } else {
            System.out.println("Sort error!");
        }
    }
}