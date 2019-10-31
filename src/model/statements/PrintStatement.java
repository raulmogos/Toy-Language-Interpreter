package model.statements;

import model.symbols.Symbols;
import utils.exceptions.LogicExpressionError;
import model.ProgramState;
import model.expressions.Expression;
import model.output.IOutput;
import model.values.Value;

public class PrintStatement implements Statement {

    private Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws LogicExpressionError {
        IOutput<Value> output = state.getOutput();
        output.add(expression.evaluate(state.getSymbols()));
        return state;
    }

    @Override
    public String toString() {
        return Symbols.PRINT + "(" + expression.toString() + ")";
    }
}
