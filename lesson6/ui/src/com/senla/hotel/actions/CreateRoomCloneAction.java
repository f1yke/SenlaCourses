package com.senla.hotel.actions;

import com.senla.hotel.api.IAction;
import com.senla.hotel.facade.Hotel;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

public class CreateRoomCloneAction implements IAction {
    private Logger logger = Logger.getLogger(CreateRoomCloneAction.class);

    @Override
    public void execute() {
        try {
            Hotel hotel = Hotel.getInstance();
            System.out.print("Select a room from the list: ");
            Scanner scanner = new Scanner(System.in);
            Integer id = scanner.nextInt() - 1;
            System.out.print("Enter new room number: ");
            Integer number = scanner.nextInt();
            Integer cloneId = hotel.createClone(id, number);
            System.out.println(cloneId);
            if (cloneId != -1) {
                System.out.print("Room successfully copied!\nDo you want to change anything?[yes or no]");
                String ans = scanner.next();
                if (Objects.equals(ans, "y") || Objects.equals(ans, "yes")) {
                    System.out.print("Enter price: ");
                    Double price = scanner.nextDouble();
                    System.out.print("Enter capacity: ");
                    Integer capacity = scanner.nextInt();
                    System.out.print("Enter count stars: ");
                    Integer countStars = scanner.nextInt();
                    System.out.print("Enter status [NOT_USED or REPAIR]: ");
                    String status = scanner.next();
                    if (hotel.updateRoom(cloneId, price, capacity, countStars, status)) {
                        System.out.println("Room details changed successfully!");
                    } else {
                        System.out.println("Error! Room details are not changed!");
                    }
                }
            } else {
                System.out.println("Error! Room not copied!");
            }
        } catch (Exception e) {
            logger.error("Error!");
            System.out.println("Error!");
        }
    }
}