package model.types;

import syntax.Symbols;
import model.values.BoolValue;
import model.values.Value;

public class BoolType implements Type {

    private static final boolean DEFAULT_VALUE = false;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BoolType;
    }

    @Override
    public String toString() {
        return Symbols.BOOL;
    }

    @Override
    public Value getDefaultValue() {
        return new BoolValue(DEFAULT_VALUE);
    }
}
