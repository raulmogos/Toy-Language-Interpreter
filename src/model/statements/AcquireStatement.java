package model.statements;

import javafx.util.Pair;
import model.ProgramState;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import model.values.Value;
import utils.collections.map.IMyMap;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.TypeError;

import java.util.List;

public class AcquireStatement implements Statement {

    private String symbol;

    public AcquireStatement(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public ProgramState execute(ProgramState state) {

        System.out.println(state);

        if (!state.getSymbolsTable().isKeyInMap(symbol)) {
            throw new DoesNotExistError("AcquireStatement: should exists in SymbolsTable");
        }

        Value value = state.getSymbolsTable().get(symbol);
        if (!value.getType().equals(new IntType())) {
            throw new TypeError("AcquireStatement: should be int");
        }

        IntValue intValue = (IntValue) value;

        IMyMap<Integer, Pair<Integer, List<Integer>>> semaphoreTable = state.getSemaphoreTable();

        synchronized (semaphoreTable) {

            if (!semaphoreTable.isKeyInMap(intValue.getValue())) {
                throw new DoesNotExistError("AcquireStatement: should exists in SemaphoreTable");
            }

            Pair<Integer, List<Integer>> entryValue = semaphoreTable.get(intValue.getValue());
            int nr = entryValue.getKey();
            List<Integer> list = entryValue.getValue();
            synchronized (list) {
                int sizeList = list.size();
                if (state.getId() + nr - 1 > sizeList) {
                    if (!list.contains(state.getId())) {
                        list.add(state.getId());
                    }
                } else {
                    state.getExecutionStack().push(this);
                }
            }
        }

        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        return null;
    }

    @Override
    public String toString() {
        return "ACQUIRE( " + symbol + " ) ";
    }
}
