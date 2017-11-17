package actions;

import api.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class SettleAction implements IAction {
    private Logger logger = Logger.getLogger(SettleAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter client number: ");
            Integer clientId = scanner.nextInt() - 1;
            System.out.print("Enter room number: ");
            Integer roomId = scanner.nextInt() - 1;
            System.out.print("Enter date of settle(example: 17-11-2017)");
            String dateOfSettle = scanner.next();
            System.out.print("Enter date eviction(example: 19-11-2017)");
            String dateEviction = scanner.next();
            if (hotel.settleInRoom(clientId, roomId, dateOfSettle, dateEviction)) {
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