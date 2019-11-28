package model.statements;

import model.ProgramState;
import model.expressions.Expression;
import model.types.BoolType;
import model.types.Type;
import model.values.BoolValue;
import model.values.Value;
import syntax.Symbols;
import utils.exceptions.TypeError;

public class WhileStatement implements Statement {

    private Expression expression;
    private Statement statement;

    public WhileStatement(Expression expression, Statement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public void execute(ProgramState state) {
        Value valueExpression = expression.evaluate(state.getSymbolsTable(), state.getHeap());
        if (!(valueExpression.getType().equals(new BoolType()))) {
            throw new TypeError("at while statement -> type error -> should be BoolType");
        }
        BoolValue boolValueExpression = (BoolValue) valueExpression;
        if (boolValueExpression.getValue()) {
            state.getExecutionStack().push(this);
            state.getExecutionStack().push(statement);
        }
    }

    @Override
    public String toString() {
        return Symbols.WHILE + " (" + expression.toString() + "): { " +  statement.toString() + " }" ;
    }
}
