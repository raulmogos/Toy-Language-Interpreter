package repository;

import controller.garbage_collector.GarbageCollector;
import model.ProgramState;

public interface IStateRepository {
    void addProgramState(ProgramState programState);
    ProgramState getCurrentProgram();
    void logCurrentProgramStateExecution();
    void logGarbageCollectorHasBeenApplied();
}
