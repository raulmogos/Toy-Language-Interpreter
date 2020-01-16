package model.statements;

import model.types.Type;
import utils.exceptions.DoesAlreadyExistError;
import utils.exceptions.FileNotFoundError;
import utils.collections.map.IMyMap;
import model.expressions.Expression;
import utils.exceptions.TypeError;
import model.values.StringValue;
import model.types.StringType;
import syntax.Symbols;
import model.ProgramState;
import model.values.Value;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public class OpenFile implements Statement {

    private Expression expression;

    public OpenFile(Expression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        Value value = this.expression.evaluate(state.getSymbolsTable(), state.getHeap());
        if (!value.getType().equals(new StringType())) {
            throw new TypeError("should be string");
        }
        StringValue stringValue = (StringValue)value;
        IMyMap<StringValue, BufferedReader> fileTable = state.getFileTable();
        if (fileTable.isKeyInMap(stringValue)) {
            throw new DoesAlreadyExistError();
        }
        try {
            fileTable.put(stringValue, new BufferedReader(new FileReader(stringValue.toStringValueOnly())));
        } catch(FileNotFoundException error) {
            throw new FileNotFoundError(error.getMessage());
        }
        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        Type expressionType = expression.typeCheck(typeEnvironment);
        if (!expressionType.equals(new StringType())) {
            throw new TypeError("OpenFile: should be string");
        }
        return typeEnvironment;
    }

    @Override
    public String toString() {
        return Symbols.OPEN_FILE + "(" + expression.toString() + ")";
    }
}
