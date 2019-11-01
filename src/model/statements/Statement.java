package model.statements;

import utils.exceptions.*;
import model.ProgramState;

public interface Statement {
    ProgramState execute(ProgramState state) throws LogicExpressionError, DoesNotExistError, TypeError, DoesAlreadyExist, DivisionByZeroError;
}
