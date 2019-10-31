package model.statements;

import utils.exceptions.DoesNotExistError;
import model.ProgramState;
import model.expressions.ValueExpression;
import model.symbol_table.ISymbolTable;
import model.values.Value;
import utils.exceptions.TypeError;

public class AssignmentStatement implements Statement {

    private String symbol;
    private ValueExpression valueExpression;

    public AssignmentStatement(String symbol, ValueExpression valueExpression) {
        this.symbol = symbol;
        this.valueExpression = valueExpression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DoesNotExistError, TypeError {
        ISymbolTable<String, Value> symbolTable = state.getSymbols();
        if (!symbolTable.isSymbolInTable(symbol)) throw new DoesNotExistError();
        Value oldValue = symbolTable.get(symbol);
        Value newValue = valueExpression.evaluate(symbolTable);
        if (newValue.getType() != oldValue.getType()) throw new TypeError("types does not match");
        symbolTable.put(symbol, newValue);
        return state;
    }
}
