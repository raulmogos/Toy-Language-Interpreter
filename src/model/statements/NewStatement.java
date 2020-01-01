package model.statements;

import model.ProgramState;
import model.expressions.Expression;
import model.types.RefType;
import model.values.RefValue;
import model.values.Value;
import syntax.Symbols;
import utils.collections.map.IMyMap;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.TypeError;

public class NewStatement implements Statement {

    // TODO: explicatie lab
    // TODO: change address implementation
    private static int address = 0;

    private String variableName;
    private Expression expression;

    public NewStatement(String variableName, Expression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) {

        // check whether var_name is a variable in SymTable and its type is a RefType.
        // If not, the execution is stopped with an appropriate error message.
        IMyMap<String, Value> symbolsTable = state.getSymbolsTable();
        if (!symbolsTable.isKeyInMap(variableName)) {
            throw new DoesNotExistError("should exist");
        }
        Value valueVariableName = symbolsTable.get(variableName);
        if (!(valueVariableName.getType() instanceof RefType)) {
            throw new TypeError("should be RefType");
        }

        // Evaluate the expression to a value
        // and then compare the type of the value to the locationType from the value associated to var_name in SymTable.
        // If the types are not equal, the execution is stopped with an appropriate error message
        Value value = expression.evaluate(symbolsTable, state.getHeap());
        RefValue refValueVariableName = (RefValue) valueVariableName;
        // this is complicated, please simplify
        if (!(value.getType().equals(((RefType)refValueVariableName.getType()).getInnerType()))) {
            throw new TypeError("should be equal");
        }

        // Create a new entry in the Heap table such that a new key (new free address) is generated and
        // it is associated to the result of the expression evaluation
        address += 1;
        state.getHeap().put(address, value);

        // in SymTable update the RefValue associated to the var_name such that the new RefValue
        // has the same locationType and the address is equal to the new key generated in the Heap at
        // the previous step
        symbolsTable.put(variableName, new RefValue(address, ((RefType) refValueVariableName.getType()).getInnerType()));

        return null;
    }

    @Override
    public String toString() {
        return  Symbols.NEW + "(" + variableName + ", " + expression.toString() + ")";
    }
}
