package model.programs;

import model.statements.*;
import model.types.IntType;
import model.values.IntValue;
import model.expressions.ValueExpression;
import model.expressions.VariableExpression;
import model.expressions.ArithmeticExpression;

class Programs {

    // int v; v=2; PRINT(v)
    static Statement program_1 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "v",
                    new IntType()
            ),
            new CompoundStatement(
                    new AssignmentStatement(
                            "v",
                            new ValueExpression(new IntValue(2))
                    ),
                    new PrintStatement(
                            new VariableExpression("v")
                    )
            )
    );

    // int a; int b; a=2+3*5; b=a+1; PRINT(b)
    static Statement program_2 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "a",
                    new IntType()
            ),
            new CompoundStatement(
                    new VariableDeclarationStatement(
                            "b",
                            new IntType()
                    ),
                    new CompoundStatement(
                            new AssignmentStatement(
                                    "a",
                                    new ArithmeticExpression(
                                            ArithmeticExpression.Operations.PLUS,
                                            new ValueExpression(new IntValue(2)),
                                            new ArithmeticExpression(
                                                    ArithmeticExpression.Operations.MULTIPLICATION,
                                                    new ValueExpression(new IntValue(3)),
                                                    new ValueExpression(new IntValue(5))
                                            )
                                    )
                            ),
                            new CompoundStatement(
                                    new AssignmentStatement(
                                            "b",
                                            new ArithmeticExpression(
                                                    ArithmeticExpression.Operations.PLUS,
                                                    new VariableExpression("a"),
                                                    new ValueExpression(new IntValue(1))
                                            )
                                    ),
                                    new PrintStatement(
                                            new VariableExpression("b")
                                    )
                            )
                    )
            )
    );
}
