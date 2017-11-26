package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;

public class ExportRoomAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.exportRooms();
    }
}