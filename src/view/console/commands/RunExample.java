package view.console.commands;

import controller.Controller;

public class RunExample extends Command {

    private Controller controller;

    public RunExample(String key, String description,Controller controller){
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try {
            controller.allStep();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}