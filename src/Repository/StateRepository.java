package Repository;

import model.ProgramState;

import java.util.ArrayList;

public class StateRepository implements IStateRepository {

    private ArrayList<ProgramState> states;

    StateRepository() {
        states = new ArrayList<ProgramState>();
    }

    @Override
    public void addProgramState(ProgramState programState) {
        states.add(programState);
    }

    @Override
    public ProgramState getCurrentProgram() {
        return states.get(states.size() - 1);
    }
}
