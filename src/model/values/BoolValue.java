package model.values;

import model.types.BoolType;
import model.types.Type;
import utils.exceptions.TypeError;

public class BoolValue implements Value {

    private boolean value;

    public BoolValue(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof BoolValue)) {
            throw new TypeError("not same type");
        }
        BoolValue objBoolValue = (BoolValue)obj;
        return value == objBoolValue.getValue();
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
