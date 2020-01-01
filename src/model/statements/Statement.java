package model.statements;

import model.ProgramState;

import java.io.FileNotFoundException;

public interface Statement {
    ProgramState execute(ProgramState state);
}
