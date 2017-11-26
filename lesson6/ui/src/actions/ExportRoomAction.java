package actions;

import api.IAction;
import facade.Hotel;

public class ExportRoomAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.exportRooms();
    }
}