package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;

public class ImportCapabilityAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.importCapabilities();
    }
}