package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class PrintCostLivingAction implements IAction {
    private Logger logger = Logger.getLogger(PrintCostLivingAction.class);

    @Override
    public void execute() {
        try {
            Hotel hotel = Hotel.getInstance();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter client number: ");
            Integer clientId = scanner.nextInt() - 1;
            if (hotel.getCost(clientId) != null) {
                System.out.println("Cost of living: " + hotel.getCost(clientId));
            } else {
                System.out.println("Error!");
            }

        } catch (Exception e) {
            logger.error("Error");
            System.out.println("Error");
        }
    }
}