package model;

import model.execution_stack.IExecutionStack;
import model.symbol_table.ISymbolTable;
import model.output.IOutput;
import model.statements.Statement;
import model.values.Value;

public class  ProgramState {

    private IExecutionStack<Statement> statements;
    private ISymbolTable<String, Value> symbols;
    private IOutput<Value> output;

    public ProgramState(IExecutionStack<Statement> statements, ISymbolTable<String, Value> symbols,
                 IOutput<Value> output, Statement program)
    {
        this.statements = statements;
        this.symbols = symbols;
        this.output = output;
        statements.push(program);
    }

    public IExecutionStack<Statement> getStatements() {
        return statements;
    }

    public void setStatements(IExecutionStack<Statement> statements) {
        this.statements = statements;
    }

    public ISymbolTable<String, Value> getSymbols() {
        return symbols;
    }

    public void setSymbols(ISymbolTable<String, Value> symbols) {
        this.symbols = symbols;
    }

    public IOutput<Value> getOutput() {
        return output;
    }

    public void setOutput(IOutput<Value> output) {
        this.output = output;
    }

    @Override
    public String toString() {

        return "ProgramState{" +
                "statements=" + statements +
                ", symbols=" + symbols +
                ", output=" + output +
                '}';
    }
}
