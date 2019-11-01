package model.statements;

import model.symbols.Symbols;
import utils.exceptions.DivisionByZeroError;
import utils.exceptions.LogicExpressionError;
import model.ProgramState;
import model.expressions.Expression;
import utils.collections.list.IMyList;
import model.values.Value;
import utils.exceptions.TypeError;

public class PrintStatement implements Statement {

    private Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws LogicExpressionError, TypeError, DivisionByZeroError {
        IMyList<Value> output = state.getOutput();
        output.add(expression.evaluate(state.getSymbolsTable()));
        return state;
    }

    @Override
    public String toString() {
        return Symbols.PRINT + "(" + expression.toString() + ")";
    }
}
