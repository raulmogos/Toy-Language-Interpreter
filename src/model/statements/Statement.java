package model.statements;

import model.ProgramState;

public interface Statement {
    void execute(ProgramState state);
}
