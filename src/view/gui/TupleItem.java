package view.gui;

import controller.Controller;

public class TupleItem {

    private String id;
    private String programString;
    private Controller controller;


    public String getId() {
        return id;
    }

    public String getProgramString() {
        return programString;
    }

    public Controller getController() {
        return controller;
    }

    public TupleItem(String id, String programString, Controller controller) {
        this.id = id;
        this.programString = programString;
        this.controller = controller;
    }
}
