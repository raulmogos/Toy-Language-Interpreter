package model.expressions;

import model.symbol_table.ISymbolTable;
import model.values.Value;

public class ValueExpression implements Expression {
    private Value value;

    public ValueExpression(Value value) {
        this.value = value;
    }

    @Override
    public Value evaluate(ISymbolTable<String, Value> symbolTable) {
        return value;
    }
}
