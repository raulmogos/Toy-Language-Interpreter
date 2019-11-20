package model.statements;

import utils.exceptions.DoesNotExistError;
import model.ProgramState;
import model.expressions.Expression;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.exceptions.TypeError;

public class AssignmentStatement implements Statement {

    private String symbol;
    private Expression expression;

    public AssignmentStatement(String symbol, Expression valueExpression) {
        this.symbol = symbol;
        this.expression = valueExpression;
    }

    @Override
    public void execute(ProgramState state) {
        IMyMap<String, Value> symbolTable = state.getSymbolsTable();
        if (!symbolTable.isKeyInMap(symbol)) throw new DoesNotExistError();
        Value oldValue = symbolTable.get(symbol);
        Value newValue = expression.evaluate(symbolTable);
        if (!newValue.getType().equals(oldValue.getType())) throw new TypeError("types do not match: " +
                oldValue.getType().toString() + " != " + newValue.getType().toString());
        symbolTable.put(symbol, newValue);
    }

    @Override
    public String toString() {
        return symbol + " = " + expression.toString();
    }
}
