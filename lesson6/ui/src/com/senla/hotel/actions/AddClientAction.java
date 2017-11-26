package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class AddClientAction implements IAction {
    private Logger logger = Logger.getLogger(AddRoomAction.class);

    @Override
    public void execute() {
        try {
            Hotel hotel = Hotel.getInstance();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name = scanner.next();
            if (hotel.addClient(name)) {
                System.out.println("Success!");
            } else {
                System.out.println("Error adding");
            }
        } catch (Exception e) {
            logger.error("Error adding");
            System.out.println("Error adding");
        }
    }
}