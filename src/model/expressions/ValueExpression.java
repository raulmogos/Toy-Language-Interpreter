package model.expressions;

import model.types.Type;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.collections.map.MyMap;

public class ValueExpression implements Expression {

    private Value value;

    public ValueExpression(Value value) {
        this.value = value;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap) {
        return value;
    }

    @Override
    public Type typeCheck(IMyMap<String, Type> typeEnvironment) {
        return value.getType();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
