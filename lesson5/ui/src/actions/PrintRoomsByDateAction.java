package actions;

import api.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;
import utils.Printer;

import java.util.Scanner;

public class PrintRoomsByDateAction implements IAction {
    private Logger logger = Logger.getLogger(PrintRoomsByDateAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter date(example: 17-11-2017): ");
            String date = scanner.next();
            if (hotel.getRoomsByDate(date) != null) {
                Printer.printArray(hotel.getRoomsByDate(date));
            } else {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            logger.error("Error!");
            System.out.println("Error!");
        }
    }
}