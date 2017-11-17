package actions;

import api.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class ChangeStatusAction implements IAction {
    private Logger logger = Logger.getLogger(ChangeStatusAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room number: ");
            Integer roomId = scanner.nextInt() - 1;
            System.out.print("Enter status [REPAIR, NOT_USED]: ");
            String status = scanner.next();
            if (hotel.changeStatus(roomId, status)) {
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