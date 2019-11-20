package model.expressions.relational_expressions;

import model.expressions.Expression;
import model.values.Value;
import utils.collections.map.IMyMap;

public class IsGreaterThanOrEqualToRelationalExpression implements Expression {

    private Expression firstExpression;
    private Expression secondExpression;

    public IsGreaterThanOrEqualToRelationalExpression(Expression firstExpression, Expression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolTable) {
        return RelationalIntExpressions.isGreaterThanOrEqualTo(firstExpression, secondExpression, symbolTable);
    }

    @Override
    public String toString() {
        return firstExpression + ">=" + secondExpression;
    }
}
