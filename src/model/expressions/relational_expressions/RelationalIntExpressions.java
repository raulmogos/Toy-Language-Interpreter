package model.expressions.relational_expressions;

import model.expressions.Expression;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.Value;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import utils.exceptions.TypeError;

class RelationalIntExpressions {

    private static void intValueTypeCheck(Expression expression, IMyMap<String, Value> symbolTable, IMyHeap<Integer,Value> heap) {
        if (!expression.evaluate(symbolTable, heap).getType().equals(new IntType())) {
            throw new TypeError("should be IntType");
        }
    }

    static BoolValue isLessThan(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable, IMyHeap<Integer,Value> heap) {
        intValueTypeCheck(expression_1, symbolTable, heap);
        intValueTypeCheck(expression_2, symbolTable, heap);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable, heap);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable, heap);

        return new BoolValue(intValueExpression_1.getValue() < intValueExpression_2.getValue());
    }

    static BoolValue isLessThanOrEqualTo(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable, IMyHeap<Integer,Value> heap) {
        intValueTypeCheck(expression_1, symbolTable, heap);
        intValueTypeCheck(expression_2, symbolTable, heap);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable, heap);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable, heap);

        return new BoolValue(intValueExpression_1.getValue() <= intValueExpression_2.getValue());
    }

    static BoolValue isEqualTo(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable, IMyHeap<Integer,Value> heap) {
        intValueTypeCheck(expression_1, symbolTable, heap);
        intValueTypeCheck(expression_2, symbolTable, heap);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable, heap);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable, heap);

        return new BoolValue(intValueExpression_1.getValue() == intValueExpression_2.getValue());
    }

    static BoolValue isNotEqualTo(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable, IMyHeap<Integer,Value> heap) {
        intValueTypeCheck(expression_1, symbolTable, heap);
        intValueTypeCheck(expression_2, symbolTable, heap);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable, heap);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable, heap);

        return new BoolValue(intValueExpression_1.getValue() != intValueExpression_2.getValue());
    }

    static BoolValue isGreaterThan(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable, IMyHeap<Integer,Value> heap) {
        intValueTypeCheck(expression_1, symbolTable, heap);
        intValueTypeCheck(expression_2, symbolTable, heap);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable, heap);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable, heap);

        return new BoolValue(intValueExpression_1.getValue() > intValueExpression_2.getValue());
    }

    static BoolValue isGreaterThanOrEqualTo(Expression expression_1, Expression expression_2, IMyMap<String, Value> symbolTable, IMyHeap<Integer,Value> heap) {
        intValueTypeCheck(expression_1, symbolTable, heap);
        intValueTypeCheck(expression_2, symbolTable, heap);

        IntValue intValueExpression_1 = (IntValue)expression_1.evaluate(symbolTable, heap);
        IntValue intValueExpression_2 = (IntValue)expression_2.evaluate(symbolTable, heap);

        return new BoolValue(intValueExpression_1.getValue() >= intValueExpression_2.getValue());
    }
}











