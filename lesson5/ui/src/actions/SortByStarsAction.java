package actions;

import api.IAction;
import facade.Hotel;

public class SortByStarsAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.sortAllRoomsByStars()) {
            System.out.println("Success!");
        } else {
            System.out.println("Sort error!");
        }
    }
}