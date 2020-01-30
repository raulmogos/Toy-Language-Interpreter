package repository;

import model.ProgramState;

import java.util.List;

public interface IStateRepository {
    void addProgramState(ProgramState programState);
    // TODO: DELETE getCurrentProgram
    ProgramState getCurrentProgram();
    void logCurrentProgramStateExecution(ProgramState programState);
    void logGarbageCollectorHasBeenApplied();
    List<ProgramState> getProgramStatesList();
    void setProgramStatesList(List<ProgramState> programStatesList);
    public void updateDataProgramState();
    public String getOutputCurrentString();
    public String getStackCurrentString(int id);
    public String getHeapCurrentString();
    public String getSymbolsCurrentString(int id);
    public String getCodeCurrentString();
    public String getFilesCurrentString();
    public String getLocksCurrentString();
}
