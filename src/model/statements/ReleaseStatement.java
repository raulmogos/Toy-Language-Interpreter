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

public class ReleaseStatement implements Statement {

    private String symbol;

    public ReleaseStatement(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        System.out.println(state);

        if (!state.getSymbolsTable().isKeyInMap(symbol)) {
            throw new DoesNotExistError("ReleaseStatement: should exists symbol");
        }

        Value value = state.getSymbolsTable().get(symbol);
        if (!value.getType().equals(new IntType())) {
            throw new TypeError("ReleaseStatement: should int");
        }

        IntValue intValue = (IntValue) value;

        IMyMap<Integer, Pair<Integer, List<Integer>>> semaphoreTable = state.getSemaphoreTable();

        synchronized (semaphoreTable) {
            if (!semaphoreTable.isKeyInMap(intValue.getValue())) {
                throw new DoesNotExistError("ReleaseStatement: should exists in SemaphoreTable");
            }

            System.out.println(semaphoreTable);
            System.out.println(intValue.getValue());
            System.out.println(semaphoreTable.isKeyInMap(intValue.getValue()));
            Pair<Integer, List<Integer>> entryValue = semaphoreTable.get(intValue.getValue());
            List<Integer> list = entryValue.getValue();
            synchronized (list) {
                if (list.contains(state.getId())) {
                    list.remove(state.getId());
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
        return "RELEASE( " + symbol + " ) ";
    }
}
