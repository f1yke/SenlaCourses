package builder;

import actions.*;
import beans.Menu;
import beans.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private Menu rootMenu;

    public Menu buildRoomsMenu(Menu rootMenu) {
        MenuItem showAllItem = new MenuItem();
        showAllItem.setTitle("Show all rooms");
        showAllItem.setAction(new PrintRoomsAction());

        MenuItem printCountFreeRoomsItem = new MenuItem();
        printCountFreeRoomsItem.setTitle("Show free rooms count");
        printCountFreeRoomsItem.setAction(new PrintCountFreeRoomsAction());

        MenuItem printCountClientsItem = new MenuItem();
        printCountClientsItem.setTitle("Show clients count");
        printCountClientsItem.setAction(new PrintCountClientsAction());

        MenuItem printLastThreeClientsItem = new MenuItem();
        printLastThreeClientsItem.setTitle("Show last three clients of the room");
        printLastThreeClientsItem.setAction(new PrintLastThreeClientsAction());

        MenuItem showFreeItem = new MenuItem();
        showFreeItem.setTitle("Show free rooms");
        showFreeItem.setAction(new PrintFreeRoomsAction());

        MenuItem sortByPriceItem = new MenuItem();
        sortByPriceItem.setTitle("Sort rooms by price");
        sortByPriceItem.setAction(new SortByPriceAction());

        MenuItem sortByCapacityItem = new MenuItem();
        sortByCapacityItem.setTitle("Sort rooms by capacity");
        sortByCapacityItem.setAction(new SortByCapacityAction());

        MenuItem sortByStarsItem = new MenuItem();
        sortByStarsItem.setTitle("Sort rooms by stars");
        sortByStarsItem.setAction(new SortByStarsAction());

        MenuItem addRoomItem = new MenuItem();
        addRoomItem.setTitle("Add room");
        addRoomItem.setAction(new AddRoomAction());

        MenuItem printDetailsItem = new MenuItem();
        printDetailsItem.setTitle("Show room details");
        printDetailsItem.setAction(new PrintRoomDetailsAction());

        MenuItem changeStatusItem = new MenuItem();
        changeStatusItem.setTitle("Change status");
        changeStatusItem.setAction(new ChangeStatusAction());

        MenuItem changePriceItem = new MenuItem();
        changePriceItem.setTitle("Change price");
        changePriceItem.setAction(new ChangeRoomPriceAction());

        MenuItem printRoomsByDateItem = new MenuItem();
        printRoomsByDateItem.setTitle("Show rooms by date");
        printRoomsByDateItem.setAction(new PrintRoomsByDateAction());

        MenuItem backItem = new MenuItem();
        backItem.setTitle("Back");
        backItem.setNextMenu(rootMenu);

        List<MenuItem> items = new ArrayList<>();
        items.add(showAllItem);
        items.add(printCountFreeRoomsItem);
        items.add(printCountClientsItem);
        items.add(printLastThreeClientsItem);
        items.add(showFreeItem);
        items.add(sortByPriceItem);
        items.add(sortByCapacityItem);
        items.add(sortByStarsItem);
        items.add(addRoomItem);
        items.add(printDetailsItem);
        items.add(changeStatusItem);
        items.add(changePriceItem);
        items.add(printRoomsByDateItem);
        items.add(backItem);

        Menu menu = new Menu();
        menu.setName("RoomsMenu");
        menu.setMenuItems(items);

        return menu;
    }

    public Menu buildClientsMenu(Menu rootMenu) {
        MenuItem printCostItem = new MenuItem();
        printCostItem.setTitle("Show cost of living in room");
        printCostItem.setAction(new PrintCostLivingAction());

        MenuItem showAllItem = new MenuItem();
        showAllItem.setTitle("Show all clients");
        showAllItem.setAction(new PrintClientsAction());

        MenuItem sortByNameItem = new MenuItem();
        sortByNameItem.setTitle("Sort by name");
        sortByNameItem.setAction(new SortByNameAction());

        MenuItem addClientItem = new MenuItem();
        addClientItem.setTitle("Add client");
        addClientItem.setAction(new AddClientAction());

        MenuItem settleItem = new MenuItem();
        settleItem.setTitle("Settle in room");
        settleItem.setAction(new SettleAction());

        MenuItem evictItem = new MenuItem();
        evictItem.setTitle("Eviction from room");
        evictItem.setAction(new EvictAction());

        MenuItem addCapabilityItem = new MenuItem();
        addCapabilityItem.setTitle("Add capability");
        addCapabilityItem.setAction(new AddCapabilityToClientAction());

        MenuItem printCapabilityItem = new MenuItem();
        printCapabilityItem.setTitle("Show client capabilities");
        printCapabilityItem.setAction(new PrintCapabilitiesClientAction());

        MenuItem sortCapabilityItem = new MenuItem();
        sortCapabilityItem.setTitle("Sort capabilities by price");
        sortCapabilityItem.setAction(new SortClientCapabilitiesAction());

        MenuItem importItem = new MenuItem();
        importItem.setTitle("Import");
        importItem.setAction(new ImportClientAction());

        MenuItem exportItem = new MenuItem();
        exportItem.setTitle("Export");
        exportItem.setAction(new ExportClientAction());

        MenuItem backItem = new MenuItem();
        backItem.setTitle("Back");
        backItem.setNextMenu(rootMenu);

        List<MenuItem> items = new ArrayList<>();
        items.add(printCostItem);
        items.add(showAllItem);
        items.add(sortByNameItem);
        items.add(addClientItem);
        items.add(settleItem);
        items.add(evictItem);
        items.add(addCapabilityItem);
        items.add(printCapabilityItem);
        items.add(sortCapabilityItem);
        items.add(importItem);
        items.add(exportItem);
        items.add(backItem);

        Menu menu = new Menu();
        menu.setName("Clients menu");
        menu.setMenuItems(items);

        return menu;
    }

    public Menu buildCapabilitiesMenu(Menu rootMenu) {
        MenuItem showAllItem = new MenuItem();
        showAllItem.setTitle("Show all capabilities");
        showAllItem.setAction(new PrintCapabilitiesAction());

        MenuItem sortByPriceItem = new MenuItem();
        sortByPriceItem.setTitle("Sort capabilities by price");
        sortByPriceItem.setAction(new SortAllCapabilitiesByPriceAction());

        MenuItem addItem = new MenuItem();
        addItem.setTitle("Add capability");
        addItem.setAction(new AddCapabilityAction());

        MenuItem changePriceItem = new MenuItem();
        changePriceItem.setTitle("Change price");
        changePriceItem.setAction(new ChangeCapabilityPriceAction());

        MenuItem backItem = new MenuItem();
        backItem.setTitle("Back");
        backItem.setNextMenu(rootMenu);

        List<MenuItem> items = new ArrayList<>();
        items.add(showAllItem);
        items.add(sortByPriceItem);
        items.add(addItem);
        items.add(changePriceItem);
        items.add(backItem);

        Menu menu = new Menu();
        menu.setName("Capability menu");
        menu.setMenuItems(items);

        return menu;
    }

    public Menu buildMenu() {
        MenuItem roomsMenuItem = new MenuItem();
        roomsMenuItem.setTitle("Rooms menu");

        MenuItem clientsMenuItem = new MenuItem();
        clientsMenuItem.setTitle("Clients menu");

        MenuItem capabilitiesMenuItem = new MenuItem();
        capabilitiesMenuItem.setTitle("Capabilities menu");

        MenuItem exitItem = new MenuItem();
        exitItem.setTitle("Exit");
        exitItem.setAction(new ExitAction());

        List<MenuItem> items = new ArrayList<>();
        items.add(roomsMenuItem);
        items.add(clientsMenuItem);
        items.add(capabilitiesMenuItem);
        items.add(exitItem);

        rootMenu = new Menu();
        rootMenu.setName("Root menu");
        rootMenu.setMenuItems(items);

        roomsMenuItem.setNextMenu(buildRoomsMenu(rootMenu));
        clientsMenuItem.setNextMenu(buildClientsMenu(rootMenu));
        capabilitiesMenuItem.setNextMenu(buildCapabilitiesMenu(rootMenu));

        return rootMenu;
    }
}