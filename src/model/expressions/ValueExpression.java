package model.expressions;

import utils.collections.map.IMyMap;
import model.values.Value;

public class ValueExpression implements Expression {

    private Value value;

    public ValueExpression(Value value) {
        this.value = value;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolTable) {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
