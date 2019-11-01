package model.expressions;

import utils.collections.map.IMyMap;
import model.values.Value;

public class VariableExpression implements Expression {

    private String symbol;

    public VariableExpression(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolTable) {
        return symbolTable.get(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
