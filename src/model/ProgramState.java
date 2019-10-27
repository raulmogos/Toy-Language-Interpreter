package model;

import model.execution_stack.IExecutionStack;
import model.symbol_table.ISymbolTable;
import model.output.IOutput;
import model.statements.IStatement;
import model.values.IValue;

public class ProgramState {

    private IExecutionStack<IStatement> statements;
    private ISymbolTable<String, IValue> symbols;
    private IOutput<IValue> output;

    ProgramState(IExecutionStack<IStatement> statements, ISymbolTable<String, IValue> symbols,
                 IOutput<IValue> output, IStatement program)
    {
        this.statements = statements;
        this.symbols = symbols;
        this.output = output;
        statements.push(program);
    }

    public IExecutionStack<IStatement> getStatements() {
        return statements;
    }

    public void setStatements(IExecutionStack<IStatement> statements) {
        this.statements = statements;
    }

    public ISymbolTable<String, IValue> getSymbols() {
        return symbols;
    }

    public void setSymbols(ISymbolTable<String, IValue> symbols) {
        this.symbols = symbols;
    }

    public IOutput<IValue> getOutput() {
        return output;
    }

    public void setOutput(IOutput<IValue> output) {
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
