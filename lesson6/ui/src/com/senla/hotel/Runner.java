package com.senla.hotel;

import com.senla.hotel.controller.MenuController;

public class Runner {
    public static void main(String[] args){
        MenuController menuController = new MenuController();
        menuController.run();
    }
}