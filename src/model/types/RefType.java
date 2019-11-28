package model.types;

import model.values.RefValue;
import model.values.Value;
import syntax.Symbols;

public class RefType implements Type {

    private static final Object DEFAULT_VALUE = null;

    private Type innerType;

    public RefType(Type innerType) {
        this.innerType = innerType;
    }

    public Type getInnerType() {
        return innerType;
    }

    @Override
    public Value getDefaultValue() {
        return new RefValue(0,innerType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RefType) {
            return innerType.equals(((RefType) obj).getInnerType());
        }
        return false;
    }

    @Override
    public String toString() {
        return  Symbols.REF + "(" + this.innerType.toString() +")";
    }
}
