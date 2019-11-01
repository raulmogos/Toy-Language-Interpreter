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

    public void setExecutionStack(IMyStack<Statement> executionStack) {
        this.executionStack = executionStack;
    }

    public IMyMap<String, Value> getSymbolsTable() {
        return symbolsTable;
    }

    public void setSymbolsTable(IMyMap<String, Value> symbolsTable) {
        this.symbolsTable = symbolsTable;
    }

    public IMyList<Value> getOutput() {
        return output;
    }

    public void setOutput(IMyList<Value> output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "\nProgramState {" +
                "\nstatements:\n\t" + executionStack.toString() +
                "\nsymbols:\n\t" + symbolsTable.toString() +
                "\noutput:\n\t" + output.toString() +
                "\n}\n";
    }
}
