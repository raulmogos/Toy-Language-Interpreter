package model.expressions;

import utils.exceptions.LogicExpressionError;
import model.symbol_table.ISymbolTable;
import model.values.Value;

public interface Expression {
    Value evaluate(ISymbolTable<String, Value> symbolTable) throws LogicExpressionError;
}
