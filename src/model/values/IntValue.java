package model.values;

import model.types.IntType;
import model.types.Type;
import utils.exceptions.TypeError;

public class IntValue implements Value {

    private int value;

    public IntValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof IntValue)) {
            throw new TypeError("not same type");
        }
        IntValue objIntValue = (IntValue)obj;
        return value == objIntValue.getValue();
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
