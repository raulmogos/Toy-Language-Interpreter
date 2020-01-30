package model.statements;

import model.ProgramState;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.TypeError;

public class UnlockStatement implements Statement {

    private String symbol;

    public UnlockStatement(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public ProgramState execute(ProgramState state) {

        if (!state.getSymbolsTable().isKeyInMap(symbol)) {
            throw new DoesNotExistError("UnlockStatement: should exist " + symbol);
        }
        if (!state.getSymbolsTable().get(symbol).getType().equals(new IntType())) {
            throw new TypeError("UnlockStatement: should be int " + symbol);
        }

        int index = ((IntValue)state.getSymbolsTable().get(symbol)).getValue();

        IMyHeap<Integer, Integer> lockTable = state.getLockTable();
        synchronized (lockTable) {
            if (!lockTable.isKeyInMap(index)) {
                throw new DoesNotExistError("LockStatement: should exist");
            }
            if (lockTable.get(index) == state.getId()) {
                lockTable.put(index, -1);
            }
        }
        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        if (!typeEnvironment.get(symbol).equals(new IntType())) {
            throw new TypeError("UnlockStatement: should be int " + symbol);
        }
        return typeEnvironment;
    }

    @Override
    public String toString() {
        return "Unlock( " + symbol + " ) ";
    }
}
