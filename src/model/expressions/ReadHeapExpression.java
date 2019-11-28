package model.expressions;

import model.types.RefType;
import model.values.RefValue;
import model.values.Value;
import syntax.Symbols;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.TypeError;

public class ReadHeapExpression implements Expression {

    private Expression expression;

    public ReadHeapExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Value evaluate(IMyMap<String, Value> symbolsTable, IMyHeap<Integer,Value> heap) {
        //the expression must be evaluated to a RefValue.
        Value value = expression.evaluate(symbolsTable, heap);
        if (!(value.getType() instanceof RefType)) {
            throw new TypeError("should be RefType");
        }

        //Take the address component of the RefValue computed before and use it to access Heap
        //table and return the value associated to that address.
        RefValue refValue = (RefValue) value;
        int address = refValue.getAddress();
        if (!(heap.isKeyInMap(address))) {
            throw new DoesNotExistError(address + " does not exists");
        }

        return heap.get(address);
    }

    @Override
    public String toString() {
        return Symbols.READ_HEAP + "(" + expression.toString() + ")";
    }
}
