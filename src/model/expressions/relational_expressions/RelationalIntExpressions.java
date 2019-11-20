package model.expressions.relational_expressions;

import model.expressions.Expression;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.Value;
import utils.collections.map.IMyMap;
import utils.exceptions.TypeError;

class RelationalIntExpressions {

    private static void intValueTypeCheck(Expression expression, IMyMap<String, Value> symbolTable) {
        if (!expression.evaluate(symbolTable).getType().equals(new IntType())) {
            throw new TypeError("should be IntType");
        }
    }

    static BoolValue isLessThan(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable) {
        intValueTypeCheck(expression_1, symbolTable);
        intValueTypeCheck(expression_2, symbolTable);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable);

        return new BoolValue(intValueExpression_1.getValue() < intValueExpression_2.getValue());
    }

    static BoolValue isLessThanOrEqualTo(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable) {
        intValueTypeCheck(expression_1, symbolTable);
        intValueTypeCheck(expression_2, symbolTable);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable);

        return new BoolValue(intValueExpression_1.getValue() <= intValueExpression_2.getValue());
    }

    static BoolValue isEqualTo(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable) {
        intValueTypeCheck(expression_1, symbolTable);
        intValueTypeCheck(expression_2, symbolTable);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable);

        return new BoolValue(intValueExpression_1.getValue() == intValueExpression_2.getValue());
    }

    static BoolValue isNotEqualTo(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable) {
        intValueTypeCheck(expression_1, symbolTable);
        intValueTypeCheck(expression_2, symbolTable);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable);

        return new BoolValue(intValueExpression_1.getValue() != intValueExpression_2.getValue());
    }

    static BoolValue isGreaterThan(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable) {
        intValueTypeCheck(expression_1, symbolTable);
        intValueTypeCheck(expression_2, symbolTable);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable);

        return new BoolValue(intValueExpression_1.getValue() > intValueExpression_2.getValue());
    }

    static BoolValue isGreaterThanOrEqualTo(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable) {
        intValueTypeCheck(expression_1, symbolTable);
        intValueTypeCheck(expression_2, symbolTable);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable);

        return new BoolValue(intValueExpression_1.getValue() >= intValueExpression_2.getValue());
    }
}











