package model.statements;

import model.ProgramState;
import model.values.StringValue;
import model.values.Value;
import syntax.Symbols;
import utils.collections.heap.IMyHeap;
import utils.collections.list.IMyList;
import utils.collections.map.IMyMap;
import utils.collections.map.MyMap;
import utils.collections.stack.IMyStack;
import utils.collections.stack.MyStack;

import java.io.BufferedReader;

public class ForkStatement implements Statement {

    private Statement statement;

    public ForkStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState state) {

        // each new program has a different execution stack
        IMyStack<Statement> executionStack = new MyStack<>();

        // we make a new map object with the same immutable objects inside
        IMyMap<String, Value> symbolsTable = new MyMap<>();
        IMyMap<String, Value> oldSymbolsTable = state.getSymbolsTable();
        oldSymbolsTable.keySet().forEach(key -> symbolsTable.put(key, oldSymbolsTable.get(key)));

        // shared resources
        IMyList<Value> output = state.getOutput();
        IMyMap<StringValue, BufferedReader> fileTable = state.getFileTable();
        IMyHeap<Integer, Value> heap = state.getHeap();

        return new ProgramState(executionStack, symbolsTable, output, fileTable, heap, this.statement);
    }

    @Override
    public String toString() {
        return Symbols.FORK + "( " + this.statement.toString() + " )";
    }
}
