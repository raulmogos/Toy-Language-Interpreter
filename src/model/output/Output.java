package model.output;

import java.util.ArrayList;

public class Output<T> implements IOutput<T> {

    private ArrayList<T> output;

    public Output() {
        output = new ArrayList<T>();
    }

    @Override
    public void add(T object) {
        output.add(object);
    }

    public ArrayList<T> getOutput() {
        return output;
    }
}
