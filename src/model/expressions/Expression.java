package model.expressions;

import utils.collections.map.IMyMap;
import model.values.Value;

public interface Expression {
    Value evaluate(IMyMap<String, Value> symbolTable);
}
