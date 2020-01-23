package model.statements;

import javafx.util.Pair;
import model.ProgramState;
import model.expressions.Expression;
import model.expressions.VariableExpression;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import model.values.Value;
import utils.collections.heap.IMyHeap;
import utils.collections.map.IMyMap;
import utils.collections.stack.IMyStack;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.TypeError;

import java.util.ArrayList;
import java.util.List;

public class CreateSemaphoreStatement implements Statement {

    private String symbol;
    private Expression expression;

    private static int location = 0;

    public CreateSemaphoreStatement(String symbol, Expression expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    private static synchronized int getNewFreeLocation() {
        location += 1;
        return location;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        // evaluate the expression exp1 using SymTable1 and Heap1 and let be
        // number1 the result of this evaluation. If number1 is not an integer then print an
        // error and stop the execution.
        System.out.println(state);
        Value value = expression.evaluate(state.getSymbolsTable(), state.getHeap());
        if (!value.getType().equals(new IntType())) {
            throw new TypeError("CreateSemaphoreStatement: should be int");
        }

        IntValue intValue = (IntValue) value;

        int newFreeLocation = getNewFreeLocation();

        IMyMap<Integer, Pair<Integer, List<Integer>>> semaphoreTable = state.getSemaphoreTable();
        synchronized (semaphoreTable) {
            semaphoreTable.put(newFreeLocation, new Pair<>(intValue.getValue(), new ArrayList<>()));
        }

        if (!state.getSymbolsTable().isKeyInMap(symbol)) {
            throw new DoesNotExistError("CreateSemaphoreStatement: should exist");
        }
        if (!state.getSymbolsTable().get(symbol).getType().equals(new IntType())) {
            throw new DoesNotExistError("CreateSemaphoreStatement: should be int");
        }
        state.getSymbolsTable().put(symbol, new IntValue (newFreeLocation));

        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        return null;
    }

    @Override
    public String toString() {
        return "CreateSemaphore( " + symbol + ", " + expression + " ) ";
    }
}
