package model.statements;

import model.ProgramState;

public class NopStatement implements Statement {
    @Override
    public ProgramState execute(ProgramState state) {
        return state;
    }
}
