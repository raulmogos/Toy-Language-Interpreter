package model.statements;

import model.types.Type;
import utils.exceptions.DoesNotExistError;
import model.ProgramState;
import model.expressions.Expression;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.exceptions.TypeError;

public class AssignmentStatement implements Statement {

    private String symbol;
    private Expression expression;

    public AssignmentStatement(String symbol, Expression valueExpression) {
        this.symbol = symbol;
        this.expression = valueExpression;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IMyMap<String, Value> symbolTable = state.getSymbolsTable();
        if (!symbolTable.isKeyInMap(symbol)) throw new DoesNotExistError();
        Value oldValue = symbolTable.get(symbol);
        Value newValue = expression.evaluate(symbolTable, state.getHeap());
        if (!newValue.getType().equals(oldValue.getType())) throw new TypeError("types do not match: " +
                oldValue.getType().toString() + " != " + newValue.getType().toString());
        symbolTable.put(symbol, newValue);
        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        Type variableType = typeEnvironment.get(symbol);
        Type expressionType = expression.typeCheck(typeEnvironment);
        if (!variableType.equals(expressionType)) {
            throw new TypeError("Assignment Statement: right hand side and left hand side have different types.");
        }
        return typeEnvironment;
    }

    @Override
    public String toString() {
        return symbol + " = " + expression.toString();
    }
}
