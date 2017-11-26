package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class PrintRoomDetailsAction implements IAction {
    private Logger logger = Logger.getLogger(PrintRoomDetailsAction.class);

    @Override
    public void execute() {
        Hotel hotel = Hotel.getInstance();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room number: ");
            Integer roomId = scanner.nextInt() - 1;
            System.out.println(hotel.getRoomDetails(roomId));
        } catch (Exception e) {
            logger.error("Error!");
            System.out.println("Error!");
        }
    }
}