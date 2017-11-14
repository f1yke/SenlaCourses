import facade.Hotel;

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
        Hotel hotel = new Hotel();
        System.out.println(" Administation of the hotel \n");
        while (true) {
            navigator.printMenu();
            Integer index = scanner.nextInt();
            navigator.navigate(index - 1);
        }
    }
}
