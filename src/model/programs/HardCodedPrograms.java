package model.programs;

import model.expressions.ValueExpression;
import model.expressions.VariableExpression;
import model.statements.*;
import model.types.IntType;
import model.values.IntValue;

public class HardCodedPrograms {
    public static Statement getProgramByIndex(int index) {
        return new CompoundStatement(new VariableDeclarationStatement("v",new IntType()),
                new CompoundStatement(new AssignmentStatement("v",
                new ValueExpression(new IntValue(2))),
                new PrintStatement(new VariableExpression("v"))));
    }
}
