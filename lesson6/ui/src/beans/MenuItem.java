package beans;

import api.IAction;

public class MenuItem {
    private String title;
    private IAction action;
    private Menu nextMenu;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public void doAction() {
        action.execute();
    }

    @Override
    public String toString() {
        return title;
    }
}