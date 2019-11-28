package model.expressions;

import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.exceptions.DoesNotExistError;

public class VariableExpression implements Expression {

    private String symbol;

    public VariableExpression(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap) {
        if (!(symbolsTable.isKeyInMap(symbol))) {
            throw new DoesNotExistError(symbol + "does not exist");
        }
        return symbolsTable.get(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
