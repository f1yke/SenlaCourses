package com.senla.hotel.controller;

import com.senla.hotel.builder.Builder;
import com.senla.hotel.navigator.Navigator;

import java.util.Scanner;

public class MenuController {
    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        builder = new Builder();
        navigator = new Navigator(builder.buildMenu());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Administation of the hotel \n");
        while (true) {
            System.out.println("\n" + navigator.getCurrentMenu().getName());
            navigator.printMenu();
            Integer index = scanner.nextInt();
            navigator.navigate(index - 1);
        }
    }
}