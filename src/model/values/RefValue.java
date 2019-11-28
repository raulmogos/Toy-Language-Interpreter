package model.values;

import model.types.RefType;
import model.types.Type;

public class RefValue implements Value {

    private int address;
    private Type locationType;

    public RefValue(int address, Type type) {
        this.address = address;
        this.locationType = type;
    }

    public int getAddress() {
        return address;
    }

    public Type getType() {
        return new RefType(locationType);
    }

    @Override
    public String toString() {
        return "(" + address + ", " + locationType.toString() + ")";
    }
}
