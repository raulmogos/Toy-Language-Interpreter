package model.statements;

import model.ProgramState;

import java.io.FileNotFoundException;

public interface Statement {
    void execute(ProgramState state);
}
