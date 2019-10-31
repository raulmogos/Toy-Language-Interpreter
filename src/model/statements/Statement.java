package model.statements;

import utils.exceptions.DoesAlreadyExist;
import utils.exceptions.DoesNotExistError;
import utils.exceptions.LogicExpressionError;
import model.ProgramState;
import utils.exceptions.TypeError;

public interface Statement {
    ProgramState execute(ProgramState state) throws LogicExpressionError, DoesNotExistError, TypeError, DoesAlreadyExist;
}
