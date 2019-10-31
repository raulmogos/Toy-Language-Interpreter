package model.statements;

import model.ProgramState;
import model.execution_stack.ExecutionStack;
import model.execution_stack.IExecutionStack;

public class CompoundStatement implements Statement {

    private Statement firstStatement;
    private Statement secondStatement;

    public CompoundStatement(Statement firstStatement, Statement secondStatement) {
        this.firstStatement = firstStatement;
        this.secondStatement = secondStatement;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IExecutionStack<Statement> stack = state.getStatements();
        stack.push(this.secondStatement);
        stack.push(this.firstStatement);
        return state;
    }

    @Override
    public String toString() {
        return firstStatement.toString() + " ; " + secondStatement.toString();
    }
}
