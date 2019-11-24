package model.statements;

import model.ProgramState;
import model.expressions.Expression;
import syntax.Symbols;
import model.types.IntType;
import model.types.StringType;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import utils.collections.map.IMyMap;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.IOError;
import utils.exceptions.TypeError;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements Statement {

    private Expression expression;
    private String variableName;

    public ReadFile(Expression expression, String variableName) {
        this.expression = expression;
        this.variableName = variableName;
    }

    @Override
    public void execute(ProgramState state) {

        IMyMap<String, Value> symbolsTable = state.getSymbolsTable();
        if (!symbolsTable.isKeyInMap(this.variableName)) {
            throw new DoesNotExistError("should exists");
        }

        Value value = symbolsTable.get(this.variableName);
        if (!(value.getType().equals(new IntType()))) {
            throw new TypeError("should be IntType");
        }

        Value expressionValue = this.expression.evaluate(symbolsTable);
        if (!expressionValue.getType().equals(new StringType())) {
            throw new TypeError("should be StringType");
        }

        StringValue expressionStringValue = (StringValue)expressionValue;
        IMyMap<StringValue, BufferedReader> fileTable = state.getFileTable();
        BufferedReader bufferedReader = fileTable.get(expressionStringValue);

        String line;
        try {
            line = bufferedReader.readLine();
            if (line == null) {
                symbolsTable.put(this.variableName, new IntValue(0));
            } else {
                symbolsTable.put(this.variableName, new IntValue(Integer.parseInt(line)));
            }
        } catch (IOException error) {
            throw new IOError(error.getMessage());
        }
    }

    @Override
    public String toString() {
        return Symbols.READ_FILE + "(" + expression.toString() + ", " + variableName + ")";
    }
}
