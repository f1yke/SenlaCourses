package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;

public class ExitAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        if (hotel.writeToFile()) {
            System.out.println("Data saved.. Good bye!");
        } else {
            System.out.println("Error! Data not saved..");
        }
        System.exit(0);
    }
}