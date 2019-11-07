package model;

import model.values.Value;
import model.statements.Statement;
import utils.collections.map.IMyMap;
import utils.collections.list.IMyList;
import utils.collections.stack.IMyStack;

public class  ProgramState {

    private IMyStack<Statement> executionStack;
    private IMyMap<String, Value> symbolsTable;
    private IMyList<Value> output;

    public ProgramState(IMyStack<Statement> statements, IMyMap<String, Value> symbols, IMyList<Value> output, Statement program) {
        this.executionStack = statements;
        this.symbolsTable = symbols;
        this.output = output;
        statements.push(program);
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

    @Override
    public String toString() {
        return "\nProgramState {" +
                "\n\tstatements:\n\t\t" + executionStack.toString() +
                "\n\tsymbols:\n\t\t" + symbolsTable.toString() +
                "\n\toutput:\n\t\t" + output.toString() +
                "\n}\n";
    }
}
