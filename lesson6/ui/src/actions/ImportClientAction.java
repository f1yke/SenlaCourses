package actions;

import api.IAction;
import facade.Hotel;

public class ImportClientAction implements IAction {
    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        hotel.importClient();
    }
}
