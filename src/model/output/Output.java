package model.output;

import java.util.ArrayList;

public class Output<T> implements IOutput<T> {

    private ArrayList<T> output;

    public Output() {
        output = new ArrayList<>();
    }

    @Override
    public void add(T object) {
        output.add(object);
    }

    public ArrayList<T> getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return output.toString();
    }
}
