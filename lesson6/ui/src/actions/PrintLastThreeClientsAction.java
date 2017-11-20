package actions;

import api.IAction;
import facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class PrintLastThreeClientsAction implements IAction {
    private Logger logger = Logger.getLogger(PrintLastThreeClientsAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room number: ");
            Integer roomId = scanner.nextInt() - 1;
            if (hotel.getLastThreeClients(roomId) != null) {
                for (String line : hotel.getLastThreeClients(roomId)) {
                    System.out.println(line);
                }
            } else {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            logger.error("Error!");
            System.out.println("Error!");
        }
    }
}