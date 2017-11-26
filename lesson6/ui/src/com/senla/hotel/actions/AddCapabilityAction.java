package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class AddCapabilityAction implements IAction {
    private Logger logger = Logger.getLogger(AddCapabilityAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter price: ");
            Double price = scanner.nextDouble();
            if (hotel.addCapability(name, price)) {
                System.out.println("Success!");
            } else {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            logger.error("Error!");
            System.out.println("Error adding");
        }
    }
}