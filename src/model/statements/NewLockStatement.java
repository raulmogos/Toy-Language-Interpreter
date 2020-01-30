package model.statements;

import model.ProgramState;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.TypeError;

public class NewLockStatement implements Statement {

    private String symbol;
    static int location;

    public NewLockStatement(String symbol) {
        this.symbol = symbol;
    }

    static synchronized private int newFreeLocation() {
        location += 1;
        return location;
    }

    @Override
    public ProgramState execute(ProgramState state) {

        IMyHeap<Integer, Integer> lockTable = state.getLockTable();
        int n = newFreeLocation();
        synchronized (lockTable) {
            lockTable.put(n, -1);
        }

        if (!state.getSymbolsTable().isKeyInMap(symbol)) {
            throw new DoesNotExistError("NewLockStatement: should exist " + symbol);
        }
        if (!state.getSymbolsTable().get(symbol).getType().equals(new IntType())) {
            throw new TypeError("NewLockStatement: should be int " + symbol);
        }

        state.getSymbolsTable().put(symbol, new IntValue(n));

        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        if (!typeEnvironment.get(symbol).equals(new IntType())) {
            throw new TypeError("NewLockStatement: should be int " + symbol);
        }
        return typeEnvironment;
    }

    @Override
    public String toString() {
        return "NewLock( " + symbol + " ) ";
    }
}
