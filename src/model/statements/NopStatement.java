package model.statements;

import model.ProgramState;

public class NopStatement implements Statement {
    @Override
    public void execute(ProgramState state) {
    }

    @Override
    public String toString() {
        return "";
    }
}
