package repository;

import model.ProgramState;

import java.io.IOException;

public interface IStateRepository {
    void addProgramState(ProgramState programState);
    ProgramState getCurrentProgram();
    void logCurrentProgramStateExecution();
}
