package Repository;

import model.ProgramState;

public interface IStateRepository {
    public void addProgramState(ProgramState programState);
    ProgramState getCurrentProgram();
}
