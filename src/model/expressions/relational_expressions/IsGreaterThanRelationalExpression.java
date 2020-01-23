package model.expressions.relational_expressions;

import model.expressions.Expression;
import model.types.BoolType;
import model.types.IntType;
import model.types.Type;
import model.values.Value;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import utils.collections.map.MyMap;
import utils.exceptions.TypeError;

public class IsGreaterThanRelationalExpression implements Expression {

    private Expression firstExpression;
    private Expression secondExpression;

    public IsGreaterThanRelationalExpression(Expression firstExpression, Expression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap) {
        return RelationalIntExpressions.isGreaterThan(firstExpression, secondExpression, symbolsTable, heap);
    }

    @Override
    public Type typeCheck(IMyMap<String, Type> typeEnvironment) {
        Type typeFirstExpression = firstExpression.typeCheck(typeEnvironment);
        Type typeSecondExpression = secondExpression.typeCheck(typeEnvironment);
        if (!typeFirstExpression.equals(new IntType())) {
            throw new TypeError("first operand is not an integer");
        }
        if (!typeSecondExpression.equals(new IntType())) {
            throw new TypeError("second operand is not an integer");
        }
        return new BoolType();
    }

    @Override
    public String toString() {
        return firstExpression + ">" + secondExpression;
    }
}
