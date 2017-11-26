package com.senla.hotel.navigator;

import com.senla.hotel.beans.Menu;

public class Navigator {
    private Menu currentMenu;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public Navigator(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void printMenu() {
        for (int i = 1; i <= currentMenu.getMenuItems().size(); i++) {
            System.out.println(i + ". " + currentMenu.getMenuItems().get(i - 1).toString());
        }
    }

    public void navigate(Integer index) {
        if (currentMenu.getMenuItems().get(index) != null) {
            if (currentMenu.getMenuItems().get(index).getAction() != null) {
                currentMenu.getMenuItems().get(index).doAction();
            } else {
                currentMenu = currentMenu.getMenuItems().get(index).getNextMenu();
            }
        }
    }
}