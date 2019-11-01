package model.statements;

import model.ProgramState;
import utils.collections.stack.IMyStack;
import model.expressions.Expression;
import model.symbols.Symbols;
import model.types.BoolType;
import model.types.Type;
import model.values.BoolValue;
import model.values.Value;
import utils.exceptions.DivisionByZeroError;
import utils.exceptions.LogicExpressionError;
import utils.exceptions.TypeError;

public class IfStatement implements Statement {

    private Expression expression;
    private Statement thenStatement;
    private Statement elseStatement;

    public IfStatement(Expression expression, Statement thenStatement, Statement elseStatement) {
        this.expression = expression;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws LogicExpressionError, TypeError, DivisionByZeroError {
        Value expressionValue = expression.evaluate(state.getSymbolsTable());
        Type typeOfExpression = expressionValue.getType();
        if (!typeOfExpression.equals(new BoolType())) throw new TypeError("types does not match");
        BoolValue boolValue = (BoolValue) expressionValue;
        IMyStack<Statement> executionStack = state.getExecutionStack();
        if (boolValue.getValue()) {
            executionStack.push(thenStatement);
        } else {
            executionStack.push(elseStatement);
        }
        return state;
    }

    @Override
    public String toString() {
        return Symbols.IF + " (" + expression.toString() + ") " + Symbols.THEN + " { " +thenStatement.toString() +
                " } " + Symbols.ELSE + " { " + elseStatement.toString() + " } ";
    }
}
