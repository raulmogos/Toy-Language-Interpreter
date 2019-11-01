package model.statements;

import utils.exceptions.DivisionByZeroError;
import utils.exceptions.DoesNotExistError;
import model.ProgramState;
import model.expressions.Expression;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.exceptions.LogicExpressionError;
import utils.exceptions.TypeError;

public class AssignmentStatement implements Statement {

    private String symbol;
    private Expression expression;

    public AssignmentStatement(String symbol, Expression valueExpression) {
        this.symbol = symbol;
        this.expression = valueExpression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DoesNotExistError, TypeError, LogicExpressionError, DivisionByZeroError {
        IMyMap<String, Value> symbolTable = state.getSymbolsTable();
        if (!symbolTable.isSymbolInTable(symbol)) throw new DoesNotExistError();
        Value oldValue = symbolTable.get(symbol);
        Value newValue = expression.evaluate(symbolTable);
        if (!newValue.getType().equals(oldValue.getType())) throw new TypeError("types does not match: " +
                oldValue.getType().toString() + " != " + newValue.getType().toString());
        symbolTable.put(symbol, newValue);
        return state;
    }

    @Override
    public String toString() {
        return symbol + " = " + expression.toString();
    }
}
