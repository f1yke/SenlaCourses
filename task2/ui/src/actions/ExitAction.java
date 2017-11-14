package actions;

import api.IAction;

public class ExitAction implements IAction{
    @Override
    public void execute() {
        System.exit(0);
    }
}
