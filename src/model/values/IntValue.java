package model.values;

import model.types.IntType;
import model.types.Type;

public class IntValue implements Value {

    private int value;

    public IntValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public Type getType() {
        return new IntType();
    }
}
