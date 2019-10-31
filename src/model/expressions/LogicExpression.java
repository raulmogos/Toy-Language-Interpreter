package model.expressions;

import utils.exceptions.LogicExpressionError;
import model.symbol_table.ISymbolTable;
import model.values.Value;

public class LogicExpression implements Expression {

    public static class Operations {
        public static int AND = 1;
        public static int OR = 2;
        public static int NOT = 3;
    }

    private Expression firstExpression;
    private Expression secondExpression;
    private int numberOfExpressions;
    private int operation;

    public LogicExpression(Expression firstExpression, Expression secondExpression, int operation) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operation = operation;
        this.numberOfExpressions = 2;
    }

    public LogicExpression(Expression firstExpression, int operation) {
        this.firstExpression = firstExpression;
        this.operation = operation;
        this.numberOfExpressions = 1;
    }

    @Override
    public Value evaluate(ISymbolTable<String, Value> symbolTable) throws LogicExpressionError {
        if (numberOfExpressions == 1 && operation != Operations.NOT)
            throw new LogicExpressionError("invalid logic expression: you should use NOT_operator in this case.");
        if (numberOfExpressions == 2 && operation == Operations.NOT)
            throw new LogicExpressionError("invalid logic expression: you should not use NOT_operator in this case.");
        return null;
    }

    @Override
    public String toString() {
//        change this
        return super.toString();
    }
}
