package model.statements;

import model.ProgramState;
import utils.collections.map.IMyMap;
import model.types.Type;
import model.values.Value;
import utils.exceptions.DoesAlreadyExistError;

public class VariableDeclarationStatement implements Statement {

    private String symbol;
    private Type type;

    public VariableDeclarationStatement(String symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IMyMap<String, Value> symbols = state.getSymbolsTable();
        if (symbols.isKeyInMap(symbol)) throw new DoesAlreadyExistError("this symbol has been declared");
        symbols.put(symbol, type.getDefaultValue());

        return null;
    }

    @Override
    public String toString() {
        return type.toString() + " " + symbol;
    }
}
