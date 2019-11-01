package model.statements;

import model.ProgramState;
import utils.collections.stack.IMyStack;

public class CompoundStatement implements Statement {

    private Statement firstStatement;
    private Statement secondStatement;

    public CompoundStatement(Statement firstStatement, Statement secondStatement) {
        this.firstStatement = firstStatement;
        this.secondStatement = secondStatement;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IMyStack<Statement> stack = state.getExecutionStack();
        stack.push(this.secondStatement);
        stack.push(this.firstStatement);
        return state;
    }

    @Override
    public String toString() {
        return firstStatement.toString() + " ; " + secondStatement.toString();
    }
}
