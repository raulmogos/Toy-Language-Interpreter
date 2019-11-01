package model.expressions;

import utils.exceptions.DivisionByZeroError;
import utils.exceptions.LogicExpressionError;
import utils.collections.map.IMyMap;
import model.values.Value;
import utils.exceptions.TypeError;

public interface Expression {
    Value evaluate(IMyMap<String, Value> symbolTable) throws LogicExpressionError, TypeError, DivisionByZeroError;
}
