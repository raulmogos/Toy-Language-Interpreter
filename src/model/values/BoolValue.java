package model.values;

import model.types.BoolType;
import model.types.Type;

public class BoolValue implements Value {

    private boolean value;

    public BoolValue(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public Type getType() {
        return new BoolType();
    }
}
