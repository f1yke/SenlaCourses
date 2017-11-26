package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class ChangeCapabilityPriceAction implements IAction {
    private Logger logger = Logger.getLogger(ChangeCapabilityPriceAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter capability number: ");
            Integer capabilityId = scanner.nextInt() - 1;
            System.out.print("Enter new price: ");
            Double price = scanner.nextDouble();
            if (hotel.changePrice(capabilityId, price)) {
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