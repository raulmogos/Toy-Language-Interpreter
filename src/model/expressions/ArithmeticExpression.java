package model.expressions;

import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.collections.map.MyMap;
import utils.exceptions.DivisionByZeroError;
import utils.exceptions.TypeError;

public class ArithmeticExpression implements Expression {

    public static class Operations {
        public static final String PLUS = "+";
        public static final String MINUS = "-";
        public static final String MULTIPLICATION = "*";
        public static final String DIVISION = "/";
    }

    private Expression firstExpression;
    private Expression secondExpression;
    private String operation;

    public ArithmeticExpression(String operation, Expression firstExpression, Expression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operation = operation;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap) {

        Value valueFirstExpression = firstExpression.evaluate(symbolsTable, heap);
        Value valueSecondExpression = secondExpression.evaluate(symbolsTable, heap);

        if (!valueFirstExpression.getType().equals(new IntType()) || !valueSecondExpression.getType().equals(new IntType()))
            throw new TypeError("invalid types");

        IntValue intValueFirstExpression = (IntValue)valueFirstExpression;
        IntValue intValueSecondExpression = (IntValue)valueSecondExpression;

        switch (operation) {
            case Operations.PLUS:
                return new IntValue(intValueFirstExpression.getValue() + intValueSecondExpression.getValue());
            case Operations.MULTIPLICATION:
                return new IntValue(intValueFirstExpression.getValue() * intValueSecondExpression.getValue());
            case Operations.DIVISION:
                if (intValueSecondExpression.getValue() == 0)
                    throw new DivisionByZeroError("division by zero");
                return new IntValue(intValueFirstExpression.getValue() / intValueSecondExpression.getValue());
            case Operations.MINUS:
                return new IntValue(intValueFirstExpression.getValue() - intValueSecondExpression.getValue());
            default:
                throw new TypeError("invalid operation");
        }
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
        return new IntType();
    }

    @Override
    public String toString() {
        return firstExpression.toString() + " " + operation + " " +  secondExpression.toString();
    }
}
