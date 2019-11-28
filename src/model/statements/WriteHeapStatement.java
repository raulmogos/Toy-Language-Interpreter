package model.statements;

import model.ProgramState;
import model.expressions.Expression;
import model.types.RefType;
import model.types.Type;
import model.values.RefValue;
import model.values.Value;
import syntax.Symbols;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.TypeError;

public class WriteHeapStatement implements Statement {

    private String variableName;
    private Expression expression;

    public WriteHeapStatement(String variableName, Expression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void execute(ProgramState state) {
        // check if variableName is a variable defined in SymTable,
        // if its type is a RefType and
        // if the address from the RefValue associated in SymTable is a key in Heap.
        IMyMap<String, Value> symbolsTable = state.getSymbolsTable();
        IMyHeap<Integer, Value> heap = state.getHeap();
        if (!(symbolsTable.isKeyInMap(variableName))) {
            throw new DoesNotExistError(variableName + " does not exist in symbol table");
        }

        Value value = symbolsTable.get(variableName);
        if (!(value.getType() instanceof RefType)) {
            throw new TypeError("should be a RefType");
        }

        RefValue refValue = (RefValue) value;
        int address = refValue.getAddress();
        if (!(heap.isKeyInMap(address))) {
            throw new DoesNotExistError(address + " does not exist");
        }

        // the expression is evaluated and
        // the result must have its type equal to the
        // locationType of the variableName type.
        Value valueExpression = expression.evaluate(symbolsTable, heap);
        Type refValueInnerType = ((RefType) refValue.getType()).getInnerType();
        if (!(valueExpression.getType().equals(refValueInnerType))) {
            throw new TypeError("type does not match");
        }

        // access the Heap using the address from variableName and that Heap entry is updated
        // to the result of the expression evaluation
        heap.put(address, valueExpression);
    }

    @Override
    public String toString() {
        return Symbols.WRITE_HEAP + "(" + variableName + expression.toString() + ")";
    }
}
