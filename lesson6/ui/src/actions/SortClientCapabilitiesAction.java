package actions;

import api.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class SortClientCapabilitiesAction implements IAction {
    private Logger logger = Logger.getLogger(SortClientCapabilitiesAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter client number: ");
            Integer clientId = scanner.nextInt() - 1;
            if (hotel.sortClientCapabilitiesByPrice(clientId)) {
                System.out.println("Success!");
            } else {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            logger.error("Error!");
            System.out.println("Error!");
        }
    }
}