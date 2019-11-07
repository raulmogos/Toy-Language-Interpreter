package model.programs;

import model.statements.*;
import model.types.BoolType;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IntValue;
import model.expressions.ValueExpression;
import model.expressions.VariableExpression;
import model.expressions.ArithmeticExpression;

public class Programs {

    public static int NUMBER_OF_PROGRAMS = 3;

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


// TODO !
// CREATE A FUNCTION THAT TAKES AS INPUT ALL THE STATEMENTS AND GIVES YOU
// BACK THE HOLE PROGRAM WITH COMPOUND STATEMENTS
//
//    new Statement[] {
//            new VariableDeclarationStatement(),
//            new VariableDeclarationStatement()
//    }

    static Statement program_3 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "a",
                    new BoolType()
            ),
            new CompoundStatement(
                    new VariableDeclarationStatement(
                            "v",
                            new IntType()
                    ),
                    new CompoundStatement(
                            new AssignmentStatement(
                                    "a",
                                    new ValueExpression(new BoolValue(true))
                            ),
                            new CompoundStatement(
                                    new IfStatement(
                                            new VariableExpression("a"),
                                            new AssignmentStatement(
                                                    "v",
                                                    new ValueExpression(new IntValue(2))
                                            ),
                                            new AssignmentStatement(
                                                    "v",
                                                    new ValueExpression(new IntValue(3))
                                            )
                                    ),
                                    new PrintStatement(new VariableExpression("v"))
                            )
                    )
            )
    );
}
