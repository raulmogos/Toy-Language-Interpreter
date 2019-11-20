package model.expressions.relational_expressions;

import model.expressions.Expression;
import model.values.Value;
import utils.collections.map.IMyMap;

public class IsLessThanOrEqualToRelationalExpression implements Expression {

    private Expression firstExpression;
    private Expression secondExpression;

    public IsLessThanOrEqualToRelationalExpression(Expression firstExpression, Expression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolTable) {
        return RelationalIntExpressions.isLessThanOrEqualTo(firstExpression, secondExpression, symbolTable);
    }

    @Override
    public String toString() {
        return firstExpression + "<=" + secondExpression;
    }
}
