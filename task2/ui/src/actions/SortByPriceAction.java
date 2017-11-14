package actions;

import api.IAction;
import facade.Hotel;
import utils.Printer;

public class SortByPriceAction implements IAction{
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.sortAllRoomsByPrice();
    }
}
