package model.types;

import syntax.Symbols;
import model.values.IntValue;
import model.values.Value;

public class IntType implements Type {

    private static final int DEFAULT_VALUE = 0;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof  IntType;
    }

    @Override
    public String toString() {
        return Symbols.INT;
    }

    @Override
    public Value getDefaultValue() {
        return new IntValue(DEFAULT_VALUE);
    }
}
