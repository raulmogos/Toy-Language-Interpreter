package model.statements;

import model.ProgramState;
import model.types.Type;
import utils.collections.map.IMyMap;

public class NopStatement implements Statement {
    @Override
    public ProgramState execute(ProgramState state) {
        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        return typeEnvironment;
    }

    @Override
    public String toString() {
        return "";
    }
}
