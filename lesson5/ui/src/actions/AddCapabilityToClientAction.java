package actions;

import api.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class AddCapabilityToClientAction implements IAction {
    private Logger logger = Logger.getLogger(AddCapabilityToClientAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter client number: ");
            Integer clientId = scanner.nextInt() - 1;
            System.out.print("Enter capability number: ");
            Integer capabilityId = scanner.nextInt() - 1;
            if (hotel.addCapability(clientId, capabilityId)) {
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