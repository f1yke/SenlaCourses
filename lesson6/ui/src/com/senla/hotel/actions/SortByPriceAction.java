package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;

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