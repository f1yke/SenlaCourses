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


            if (!hotel.getIsChangeStatus()) {
                System.out.println("Access denied!");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room number: ");
            Integer roomId = scanner.nextInt() - 1;
            System.out.print("Enter status [REPAIR, NOT_USED]: ");
            String status = scanner.next();
            Integer result = hotel.changeStatus(roomId, status);
            String message;
            switch (result) {
                case -1:
                    message = "Error while changed!";
                    break;
                case 0:
                    message = "Input error!";
                    break;
                case 1:
                    message = "Success!";
                    break;
                default:
                    message = "Error!";
                    break;
            }
            System.out.println(message);
            logger.error(message);
        } catch (Exception e) {
            logger.error("Error!");
            System.out.println("Error!");
        }
    }
}