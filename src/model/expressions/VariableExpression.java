package model.expressions;

import model.symbol_table.ISymbolTable;
import model.values.Value;

public class VariableExpression implements Expression {

    private String symbol;

    public VariableExpression(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public Value evaluate(ISymbolTable<String, Value> symbolTable) {
        return symbolTable.get(symbol);
    }
}
