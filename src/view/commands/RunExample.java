package view.commands;

import controller.Controller;

public class RunExample extends Command {
    private Controller ctr;
    public RunExample(String key, String desc,Controller ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute() {
        try{
            ctr.allStep();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        } //here you must treat the exceptions that can not be solved in the controller
    }
}