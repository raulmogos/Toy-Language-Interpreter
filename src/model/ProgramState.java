package model;

import javafx.util.Pair;
import model.values.StringValue;
import model.values.Value;
import model.statements.Statement;
import utils.collections.heap.IMyHeap;
import utils.collections.list.MyList;
import utils.collections.map.IMyMap;
import utils.collections.list.IMyList;
import utils.collections.stack.IMyStack;
import utils.exceptions.NoMoreStatementsError;

import java.io.BufferedReader;
import java.util.List;

public class ProgramState {

    private static int MAX_ID = 0;

    private IMyStack<Statement> executionStack;
    private IMyMap<String, Value> symbolsTable;
    private IMyList<Value> output;
    private IMyMap<StringValue, BufferedReader> fileTable;
    private IMyHeap<Integer, Value> heap;
    private IMyMap<Integer, Pair<Integer, List<Integer>>> semaphoreTable;
    private int id;

    public ProgramState(IMyStack<Statement> statements, IMyMap<String, Value> symbols, IMyList<Value> output, IMyMap<StringValue, BufferedReader> fileTable, IMyHeap<Integer, Value> heap, IMyMap<Integer, Pair<Integer, List<Integer>>> semaphoreTable, Statement program) {
        this.executionStack = statements;
        this.symbolsTable = symbols;
        this.output = output;
        this.fileTable = fileTable;
        this.heap = heap;
        this.id = getNewId();
        this.semaphoreTable = semaphoreTable;
        statements.push(program);
    }

    private synchronized static int getNewId() {
        MAX_ID += 1;
        return MAX_ID;
    }

    public IMyStack<Statement> getExecutionStack() {
        return executionStack;
    }

    public IMyMap<String, Value> getSymbolsTable() {
        return symbolsTable;
    }

    public IMyList<Value> getOutput() {
        return output;
    }

    public int getId() {
        return id;
    }

    public IMyMap<StringValue, BufferedReader> getFileTable() {
        return fileTable;
    }

    public IMyHeap<Integer, Value> getHeap() {
        return heap;
    }

    public Boolean isNotCompleted() {
        return !executionStack.isEmpty();
    }

    public ProgramState oneStep() {
        if (executionStack.isEmpty()) {
            throw new NoMoreStatementsError("no more statements: execution stack is empty");
        }
        Statement currentStatement = executionStack.pop();
        return currentStatement.execute(this);
    }

    @Override
    public String toString() {
        return
                "----------------------------------------------------------------------------------\n" +
                "ID: " + id + "\n" +
                "STATEMENTS:\n" + executionStack.toString() + "\n" +
                "SYMBOLS:\n" + symbolsTable.toString() + "\n" +
                "OUTPUT:\n" + output.toString() + "\n" +
                "FILE TABLE:\n" + (new MyList<>(fileTable.keySet())).toString() + "\n" +
                "HEAP:\n" + heap.toString() + "\n" +
                "SEMAPHORES TABLE:\n" + semaphoreTable.toString() + "\n" +
                "\n";
    }

    public IMyMap<Integer, Pair<Integer, List<Integer>>> getSemaphoreTable() {
        return semaphoreTable;
    }
}
