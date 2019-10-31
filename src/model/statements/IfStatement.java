package model.statements;

import model.ProgramState;
import model.execution_stack.IExecutionStack;
import model.expressions.Expression;
import model.types.BoolType;
import model.types.Type;
import model.values.BoolValue;
import model.values.Value;
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
    public ProgramState execute(ProgramState state) throws LogicExpressionError, TypeError {
        Value expressionValue = expression.evaluate(state.getSymbols());
        Type typeOfExpression = expressionValue.getType();
        if (!typeOfExpression.equals(new BoolType())) throw new TypeError("types does not match");
        BoolValue boolValue = (BoolValue) expressionValue;
        IExecutionStack<Statement> executionStack = state.getStatements();
        if (boolValue.getValue()) {
            executionStack.push(thenStatement);
        } else {
            executionStack.push(elseStatement);
        }
        return state;
    }
}
