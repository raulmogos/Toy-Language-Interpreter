package model.statements;

import model.ProgramState;
import model.symbol_table.ISymbolTable;
import model.types.Type;
import model.values.Value;
import utils.exceptions.DoesAlreadyExist;

public class VariableDeclarationStatement implements Statement {

    private String symbol;
    private Type type;

    public VariableDeclarationStatement(String symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DoesAlreadyExist {
        ISymbolTable<String, Value> symbols = state.getSymbols();
        if (symbols.isSymbolInTable(symbol)) throw new DoesAlreadyExist("this symbol has been declared");
        symbols.put(symbol, type.getDefaultValue());
        return state;
    }

    @Override
    public String toString() {
        return type.toString() + " " + symbol;
    }
}
