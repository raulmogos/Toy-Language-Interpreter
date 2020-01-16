package model.statements;

import model.ProgramState;
import utils.collections.map.IMyMap;
import utils.collections.stack.IMyStack;
import model.expressions.Expression;
import syntax.Symbols;
import model.types.BoolType;
import model.types.Type;
import model.values.BoolValue;
import model.values.Value;
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
    public ProgramState execute(ProgramState state) {
        Value expressionValue = expression.evaluate(state.getSymbolsTable(), state.getHeap());
        Type typeOfExpression = expressionValue.getType();
        if (!typeOfExpression.equals(new BoolType()))
            throw new TypeError("types does not match");
        BoolValue boolValue = (BoolValue) expressionValue;
        IMyStack<Statement> executionStack = state.getExecutionStack();
        if (boolValue.getValue()) {
            executionStack.push(thenStatement);
        } else {
            executionStack.push(elseStatement);
        }
        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        Type expressionType = expression.typeCheck(typeEnvironment);
        if (!expressionType.equals(new BoolType())) {
            throw new TypeError("The condition of IF has not the type bool");
        }
        thenStatement.typeCheck(typeEnvironment);
        elseStatement.typeCheck(typeEnvironment);
        return typeEnvironment;
    }

    @Override
    public String toString() {
        return Symbols.IF + " (" + expression.toString() + ") " + Symbols.THEN + " { " +thenStatement.toString() +
                " } " + Symbols.ELSE + " { " + elseStatement.toString() + " } ";
    }
}
