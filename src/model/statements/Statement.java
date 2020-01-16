package model.statements;

import model.ProgramState;
import model.types.Type;
import utils.collections.map.IMyMap;

public interface Statement {
    ProgramState execute(ProgramState state);
    IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment);
}
