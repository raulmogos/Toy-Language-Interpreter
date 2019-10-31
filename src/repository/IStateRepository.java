package repository;

import model.ProgramState;

public interface IStateRepository {
    void addProgramState(ProgramState programState);
    ProgramState getCurrentProgram();
}
