import controller.MenuController;
import facade.Hotel;

public class Runner {
    public static void main(String[] args){
        MenuController menuController = new MenuController();
        menuController.run();
    }
}