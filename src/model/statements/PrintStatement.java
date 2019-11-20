package model.statements;

import model.values.Value;
import model.ProgramState;
import syntax.Symbols;
import model.expressions.Expression;
import utils.collections.list.IMyList;

public class PrintStatement implements Statement {

    private Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute(ProgramState state) {
        IMyList<Value> output = state.getOutput();
        output.add(expression.evaluate(state.getSymbolsTable()));
    }

    @Override
    public String toString() {
        return Symbols.PRINT + "(" + expression.toString() + ")";
    }
}
