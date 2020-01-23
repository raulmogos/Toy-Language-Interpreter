package model.statements;

import model.types.Type;
import model.values.Value;
import model.ProgramState;
import syntax.Symbols;
import model.expressions.Expression;
import utils.collections.list.IMyList;
import utils.collections.map.IMyMap;

public class PrintStatement implements Statement {

    private Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IMyList<Value> output = state.getOutput();
        output.add(expression.evaluate(state.getSymbolsTable(), state.getHeap()));

        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        expression.typeCheck(typeEnvironment);
        return typeEnvironment;
    }

    @Override
    public String toString() {
        return Symbols.PRINT + "(" + expression.toString() + ")";
    }
}
