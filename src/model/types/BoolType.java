package model.types;

import model.symbols.Symbols;

public class BoolType implements Type {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof BoolType;
    }

    @Override
    public String toString() {
        return Symbols.BOOL;
    }
}
