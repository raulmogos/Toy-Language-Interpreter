package resources.in.programs;

import model.expressions.relational_expressions.IsGreaterThanRelationalExpression;
import model.statements.*;
import model.types.BoolType;
import model.types.IntType;
import model.types.StringType;
import model.values.BoolValue;
import model.values.IntValue;
import model.expressions.ValueExpression;
import model.expressions.VariableExpression;
import model.expressions.ArithmeticExpression;
import model.values.StringValue;

public class Programs {

    private static final String TOY_LANG_PATH_PREFIX = "src\\resources\\in\\programs\\toy_lang_files\\";
    public static int NUMBER_OF_PROGRAMS = 5;

    // int v; v=2; PRINT(v)
    public static Statement program_1 = new CompoundStatement(
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
    public static Statement program_2 = new CompoundStatement(
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
    // bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)
    public static Statement program_3 = new CompoundStatement(
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

//    string line;
//    line="test.in";
//    openRFile(line);
//    int output;
//    readFile(line,output);print(output);
//    readFile(line,output);print(output)
//    closeRFile(line)
    public static Statement program_4 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "line",
                    new StringType()
            ),
            new CompoundStatement(
                    new AssignmentStatement(
                            "line",
                            new ValueExpression(new StringValue(TOY_LANG_PATH_PREFIX + "test.in"))
                    ),
                    new CompoundStatement(
                            new OpenFile(
                                new VariableExpression("line")
                            ),
                            new CompoundStatement(
                                    new VariableDeclarationStatement(
                                            "output",
                                            new IntType()
                                    ),
                                    new CompoundStatement(
                                            new ReadFile(
                                                    new VariableExpression("line"),
                                                    "output"
                                            ),
                                            new CompoundStatement(
                                                    new PrintStatement(
                                                            new VariableExpression("output")
                                                    ),
                                                    new CompoundStatement(
                                                            new ReadFile(
                                                                    new VariableExpression("line"),
                                                                    "output"
                                                            ),
                                                            new CompoundStatement(
                                                                    new PrintStatement(
                                                                            new VariableExpression("output")
                                                                    ),
                                                                    new CloseFile(
                                                                            new VariableExpression("line")
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

    // int a; int b; a=2, b=3, if(a>b) then print(a) else print(b)
    public static Statement program_5 = new CompoundStatement(
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
                                    new ValueExpression(new IntValue(2))
                            ),
                            new CompoundStatement(
                                    new AssignmentStatement(
                                            "b",
                                            new ValueExpression(new IntValue(3))
                                    ),
                                    new IfStatement(
                                            new IsGreaterThanRelationalExpression(
                                                    new VariableExpression("a"),
                                                    new VariableExpression("b")
                                            ),
                                            new PrintStatement(
                                                    new VariableExpression("a")
                                            ),
                                            new PrintStatement(
                                                    new VariableExpression("b")
                                            )
                                    )
                            )
                    )
            )
    );
}
