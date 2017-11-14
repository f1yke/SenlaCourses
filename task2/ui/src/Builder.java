import actions.ExitAction;
import actions.PrintClientsAction;
import actions.PrintRoomsAction;
import actions.SortByPriceAction;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private Menu rootMenu;

    public Menu getRootMenu() {
        return rootMenu;
    }

    public Menu buildMenu() {
        Menu menu = new Menu();
        List<MenuItem> menuItems = new ArrayList<>();

        MenuItem printRoomsItem = new MenuItem();
        printRoomsItem.setTitle("Show all rooms");
        printRoomsItem.setAction(new PrintRoomsAction());

        MenuItem sortRoomsByPriceItem = new MenuItem();
        sortRoomsByPriceItem.setTitle("Sort rooms by price");
        sortRoomsByPriceItem.setAction(new SortByPriceAction());

        MenuItem showClientsItem = new MenuItem();
        showClientsItem.setTitle("Show clients");
        showClientsItem.setAction(new PrintClientsAction());

        MenuItem exitItem = new MenuItem();
        exitItem.setTitle("exit");
        exitItem.setAction(new ExitAction());

        menuItems.add(printRoomsItem);
        menuItems.add(sortRoomsByPriceItem);
        menuItems.add(showClientsItem);
        menuItems.add(exitItem);

        menu.setMenuItems(menuItems);
        return menu;
    }
}
