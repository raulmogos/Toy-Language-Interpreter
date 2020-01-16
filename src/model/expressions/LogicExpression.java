package model.expressions;

import model.types.BoolType;
import model.types.IntType;
import model.types.Type;
import model.values.BoolValue;
import utils.collections.heap.IMyHeap;
import utils.collections.map.MyMap;
import utils.exceptions.LogicExpressionError;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.exceptions.TypeError;

public class LogicExpression implements Expression {

    public static class Operations {
        public static int AND = 1;
        public static int OR = 2;
        public static int NOT = 3;
    }

    private Expression firstExpression;
    private Expression secondExpression;
    private boolean isSingleExpression;
    private int operation;

    public LogicExpression(Expression firstExpression, Expression secondExpression, int operation) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operation = operation;
        this.isSingleExpression = false;
    }

    public LogicExpression(Expression firstExpression, int operation) {
        this.firstExpression = firstExpression;
        this.operation = operation;
        this.isSingleExpression = true;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap) {
        if (isSingleExpression) {
            if (operation != Operations.NOT)
                throw new LogicExpressionError("invalid logic expression: you should use NOT_operator in this case.");
            Value value = firstExpression.evaluate(symbolsTable, heap);
            if (!value.getType().equals(new BoolType()))
                throw new TypeError("this is not a bool type");
            BoolValue boolValue = (BoolValue)value;
            return new BoolValue(!boolValue.getValue());
        }
        // is not a single expression
        if (operation == Operations.NOT)
            throw new LogicExpressionError("invalid logic expression: you should not use NOT_operator in this case.");
        Value valueFirstExpression = firstExpression.evaluate(symbolsTable, heap);
        Value valueSecondExpression = secondExpression.evaluate(symbolsTable, heap);
        if (!valueFirstExpression.getType().equals(new BoolType()) || !valueSecondExpression.getType().equals(new BoolType()))
            throw new TypeError("this is not a bool type");
        BoolValue boolValueFirstExpression = (BoolValue)valueFirstExpression;
        BoolValue boolValueSecondExpression = (BoolValue)valueSecondExpression;
        if (operation == Operations.AND) {
            return new BoolValue(boolValueFirstExpression.getValue() && boolValueSecondExpression.getValue());
        }
        return new BoolValue(boolValueFirstExpression.getValue() || boolValueSecondExpression.getValue());
    }

    @Override
    public Type typeCheck(IMyMap<String, Type> typeEnvironment) {
        Type typeFirstExpression = firstExpression.typeCheck(typeEnvironment);
        Type typeSecondExpression = secondExpression != null ? secondExpression.typeCheck(typeEnvironment) : null;
        if (!typeFirstExpression.equals(new BoolType())) {
            throw new TypeError("first operand is not a boolean");
        }
        if ( typeSecondExpression != null ) {
            if (!typeSecondExpression.equals(new BoolType())) {
                throw new TypeError("second operand is not a boolean");
            }
        }
        return new BoolType();
    }

    @Override
    public String toString() {
//        change this
        return super.toString();
    }
}
