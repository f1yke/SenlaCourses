package actions;

import api.IAction;
import facade.Hotel;

public class SortByNameAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.sortClientsByName()) {
            System.out.println("Success!");
        } else {
            System.out.println("Error!");
        }
    }
}