package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class ChangeRoomPriceAction implements IAction {
    private Logger logger = Logger.getLogger(ChangeRoomPriceAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room number: ");
            Integer roomId = scanner.nextInt() - 1;
            System.out.print("Enter new price: ");
            Integer price = scanner.nextInt();
            if (hotel.changePrice(roomId, price)) {
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