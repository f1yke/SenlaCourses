package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class AddRoomAction implements IAction {
    private Logger logger = Logger.getLogger(AddRoomAction.class);

    @Override
    public void execute() {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.print("Enter number: ");
            Scanner scanner = new Scanner(System.in);
            Integer number = scanner.nextInt();
            System.out.print("Enter price: ");
            Double price = scanner.nextDouble();
            System.out.print("Enter capacity: ");
            Integer capacity = scanner.nextInt();
            System.out.print("Enter count stars: ");
            Integer countStars = scanner.nextInt();
            if (hotel.addRoom(number, price, capacity, countStars)) {
                System.out.println("Success!");
            } else {
                System.out.println("Error adding!");
            }
        } catch (Exception e) {
            System.out.println("Error adding");
            logger.error("Error adding");
        }
    }
}