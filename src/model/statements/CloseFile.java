package model.statements;

import model.ProgramState;
import model.expressions.Expression;
import syntax.Symbols;
import model.types.StringType;
import model.values.StringValue;
import model.values.Value;
import utils.collections.map.IMyMap;
import utils.exceptions.IOError;
import utils.exceptions.TypeError;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseFile implements Statement {

    private Expression expression;

    public CloseFile(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute(ProgramState state) {

        IMyMap<String, Value> symbolsTable = state.getSymbolsTable();
        Value expressionValue = this.expression.evaluate(symbolsTable, state.getHeap());
        if (!expressionValue.getType().equals(new StringType())) {
            throw new TypeError("should be StringType");
        }

        StringValue expressionStringValue = (StringValue)expressionValue;
        IMyMap<StringValue, BufferedReader> fileTable = state.getFileTable();
        BufferedReader bufferedReader = fileTable.get(expressionStringValue);

        try {
            bufferedReader.close();
        } catch (IOException error) {
            throw new IOError(error.getMessage());
        }

        fileTable.remove(expressionStringValue);
    }

    @Override
    public String toString() {
        return Symbols.CLOSE_FILE + "(" + expression.toString() + ")";
    }
}
