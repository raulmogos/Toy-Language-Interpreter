package model.expressions;

import model.symbol_table.ISymbolTable;
import model.values.Value;

public class ArithmeticExpression implements Expression {

    public static class Operations {
        public static int PLUS = 1;
        public static int MINUS = 2;
        public static int MULTIPLICATION = 3;
        public static int DIVISION = 4;
    }

    private Expression firstExpression;
    private Expression secondExpression;
    private int operation;

    public ArithmeticExpression(Expression firstExpression, Expression secondExpression, int operation) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operation = operation;
    }

    @Override
    public Value evaluate(ISymbolTable<String, Value> symbolTable) {
        return null;
    }

    @Override
    public String toString() {
        return firstExpression.toString() + " operation " + secondExpression.toString();
    }
}
