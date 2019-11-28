package model.expressions.relational_expressions;

import model.expressions.Expression;
import model.values.Value;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;

public class areEqualRelationalExpression implements Expression {

    private Expression firstExpression;
    private Expression secondExpression;

    public areEqualRelationalExpression(Expression firstExpression, Expression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap) {
        return RelationalIntExpressions.isEqualTo(firstExpression, secondExpression, symbolsTable, heap);
    }

    @Override
    public String toString() {
        return firstExpression + "==" + secondExpression;
    }
}
