package model.types;

import syntax.Symbols;
import model.values.StringValue;
import model.values.Value;

public class StringType implements Type {

    private static final String DEFAULT_VALUE = "";

    @Override
    public boolean equals(Object obj) {
        return obj instanceof  StringType;
    }

    @Override
    public String toString() {
        return Symbols.STRING;
    }

    @Override
    public Value getDefaultValue() {
        return new StringValue(DEFAULT_VALUE);
    }
}
