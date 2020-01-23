package resources.in.programs;

import model.expressions.ReadHeapExpression;
import model.expressions.relational_expressions.IsGreaterThanRelationalExpression;
import model.expressions.relational_expressions.IsLessThanRelationalExpression;
import model.expressions.ArithmeticExpression;
import model.expressions.VariableExpression;
import model.expressions.ValueExpression;
import model.types.RefType;
import model.values.*;
import model.types.StringType;
import model.types.BoolType;
import model.types.IntType;
import model.statements.*;

import java.util.ArrayList;

public class Programs {

    private static final String TOY_LANG_PATH_PREFIX = "src\\resources\\in\\toy_lang_files\\";
    public static int NUMBER_OF_PROGRAMS = 13;

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

    // int a; int b; a=2, b=3, if(a<b) then print(a) else print(b)
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
                                            new IsLessThanRelationalExpression(
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

    // Ref int v;new(v,20);Ref Ref int a; new(a,v);print(v);print(a)
    public static Statement program_6 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "v",
                    new RefType(new IntType())
            ),
            new CompoundStatement(
                    new NewStatement(
                            "v",
                            new ValueExpression(new IntValue(20))
                    ),
                    new CompoundStatement(
                            new VariableDeclarationStatement(
                                    "a",
                                    new RefType(new RefType(new IntType()))
                            ),
                            new CompoundStatement(
                                    new NewStatement(
                                            "a",
                                            new VariableExpression("v")
                                    ),
                                    new CompoundStatement(
                                        new PrintStatement(new VariableExpression("v")),
                                        new PrintStatement(new VariableExpression("a"))
                                    )
                            )
                    )
            )
    );

    // Ref int v; new(v,20); Ref Ref int a; new(a,v); print(readHeap(v)); print(readHeap(readHeap(a))+5)
    public static Statement program_7 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "v",
                    new RefType(new IntType())
            ),
            new CompoundStatement(
                    new NewStatement(
                            "v",
                            new ValueExpression(new IntValue(20))
                    ),
                    new CompoundStatement(
                            new VariableDeclarationStatement(
                                    "a",
                                    new RefType(new RefType(new IntType()))
                            ),
                            new CompoundStatement(
                                    new NewStatement(
                                            "a",
                                            new VariableExpression("v")
                                    ),
                                    new CompoundStatement(
                                            new PrintStatement(
                                                    new ReadHeapExpression(
                                                            new VariableExpression("v")
                                                    )
                                            ),
                                            new PrintStatement(
                                                    new ArithmeticExpression(
                                                            ArithmeticExpression.Operations.PLUS,
                                                            new ReadHeapExpression(
                                                                new ReadHeapExpression(
                                                                        new VariableExpression("a")
                                                                )
                                                            ),
                                                            new ValueExpression(new IntValue(5))
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

    // Ref int v; new(v,20); print(rH(v)); wH(v,30); print(rH(v)+5);
    public static Statement program_8 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "v",
                    new RefType(new IntType())
            ),
            new CompoundStatement(
                    new NewStatement(
                            "v",
                            new ValueExpression(new IntValue(20))
                    ),
                    new CompoundStatement(
                            new PrintStatement(
                                    new ReadHeapExpression(
                                            new VariableExpression("v")
                                    )
                            ),
                            new CompoundStatement(
                                    new WriteHeapStatement(
                                            "v",
                                            new ValueExpression(new IntValue(30))
                                    ),
                                    new PrintStatement(
                                            new ArithmeticExpression(
                                                    ArithmeticExpression.Operations.PLUS,
                                                    new ReadHeapExpression(
                                                            new VariableExpression("v")
                                                    ),
                                                    new ValueExpression(new IntValue(5))
                                            )
                                    )
                            )
                    )
            )
    );

    // Ref int v; new(v,20); Ref Ref int a; new(a,v); new(v,30); print(rH(rH(a)))
    public static Statement program_9 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "v",
                    new RefType(new IntType())
            ),
            new CompoundStatement(
                    new NewStatement(
                            "v",
                            new ValueExpression(new IntValue(20))
                    ),
                    new CompoundStatement(
                            new VariableDeclarationStatement(
                                    "a",
                                    new RefType(new RefType(new IntType()))
                            ),
                            new CompoundStatement(
                                    new NewStatement(
                                            "a",
                                            new VariableExpression("v")
                                    ),
                                    new CompoundStatement(
                                            new NewStatement(
                                                    "v",
                                                    new ValueExpression(new IntValue(30))
                                            ),
                                            new PrintStatement(
                                                new ReadHeapExpression(
                                                        new ReadHeapExpression(
                                                                new VariableExpression("a")
                                                        )
                                                )
                                            )
                                    )
                            )
                    )
            )
    );

    // int v; v=4; (while (v>0) print(v); v=v-1); print(v)
    public static Statement program_10 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "v",
                    new IntType()
            ),
            new CompoundStatement(
                    new AssignmentStatement(
                            "v",
                            new ValueExpression(new IntValue(4))
                    ),
                    new CompoundStatement(
                            new WhileStatement(
                                    new IsGreaterThanRelationalExpression(
                                            new VariableExpression("v"),
                                            new ValueExpression(new IntValue(0))
                                    ),
                                    new CompoundStatement(
                                            new PrintStatement(
                                                    new VariableExpression("v")
                                            ),
                                            new AssignmentStatement(
                                                    "v",
                                                    new ArithmeticExpression(
                                                            ArithmeticExpression.Operations.MINUS,
                                                            new VariableExpression("v"),
                                                            new ValueExpression(new IntValue(1))
                                                    )
                                            )
                                    )
                            ),
                            new PrintStatement(
                                    new VariableExpression("v")
                            )
                    )
            )
    );

    // Ref int v; new(v,20); Ref Ref int a; new(a,v); new(v,30); new(v, 40) print(rH(rH(a)))
    public static Statement program_11 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "v",
                    new RefType(new IntType())
            ),
            new CompoundStatement(
                    new NewStatement(
                            "v",
                            new ValueExpression(new IntValue(20))
                    ),
                    new CompoundStatement(
                            new VariableDeclarationStatement(
                                    "a",
                                    new RefType(new RefType(new IntType()))
                            ),
                            new CompoundStatement(
                                    new NewStatement(
                                            "a",
                                            new VariableExpression("v")
                                    ),
                                    new CompoundStatement(
                                            new NewStatement(
                                                    "v",
                                                    new ValueExpression(new IntValue(30))
                                            ),
                                            new CompoundStatement(
                                                    new NewStatement(
                                                            "v",
                                                            new ValueExpression(new IntValue(40))
                                                    ),
                                                    new PrintStatement(
                                                            new ReadHeapExpression(
                                                                    new ReadHeapExpression(
                                                                            new VariableExpression("a")
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

    // int v; Ref int a; v=10; new(a,22);
    // fork( wH(a,30); v=32; print(v); print(rH(a)));
    // print(v); print(rH(a))
    public static Statement program_12 = new CompoundStatement(
            new VariableDeclarationStatement(
                    "v",
                    new IntType()
            ),
            new CompoundStatement(
                    new VariableDeclarationStatement(
                            "a",
                            new RefType(new IntType())
                    ),
                    new CompoundStatement(
                            new AssignmentStatement(
                                    "v",
                                    new ValueExpression(new IntValue(10))
                            ),
                            new CompoundStatement(
                                    new NewStatement(
                                            "a",
                                            new ValueExpression(new IntValue(22))
                                    ),
                                    new CompoundStatement(
                                            new ForkStatement(
                                                    new CompoundStatement(
                                                            new WriteHeapStatement(
                                                                    "a",
                                                                    new ValueExpression(new IntValue(30))
                                                            ),
                                                            new CompoundStatement(
                                                                    new AssignmentStatement(
                                                                            "v",
                                                                            new ValueExpression(new IntValue(32))
                                                                    ),
                                                                    new CompoundStatement(
                                                                            new PrintStatement(
                                                                                    new VariableExpression(
                                                                                            "v"
                                                                                    )
                                                                            ),
                                                                            new PrintStatement(
                                                                                    new ReadHeapExpression(
                                                                                            new VariableExpression(
                                                                                                    "a"
                                                                                            )
                                                                                    )
                                                                            )
                                                                    )
                                                            )
                                                    )
                                            ),
                                            new CompoundStatement(
                                                    new PrintStatement(
                                                            new VariableExpression(
                                                                    "v"
                                                            )
                                                    ),
                                                    new PrintStatement(
                                                            new ReadHeapExpression(
                                                                    new VariableExpression(
                                                                            "a"
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );


    public static Statement program_13 = HardCodedPrograms.createTreeStatement(
            new ArrayList<>() {{
                add(new VariableDeclarationStatement("v1", new RefType(new IntType())));
                add(new VariableDeclarationStatement("cnt", new IntType()));
                add(new NewStatement("v1", new ValueExpression(new IntValue(1))));
                add(new CreateSemaphoreStatement("cnt", new ReadHeapExpression(new VariableExpression("v1"))));
                add(new ForkStatement(
                        HardCodedPrograms.createTreeStatement(
                                new ArrayList<>() {{
                                    add(new AcquireStatement("cnt"));
                                    add(new WriteHeapStatement("v1", new ArithmeticExpression(
                                                    ArithmeticExpression.Operations.MULTIPLICATION,
                                                    new ValueExpression(new IntValue(10)),
                                                    new ReadHeapExpression(new VariableExpression("v1"))
                                            )
                                    ));
                                    add(new PrintStatement(new ReadHeapExpression(new VariableExpression("v1"))));
                                    add(new ReleaseStatement("cnt"));
                                }}
                        ))
                );
                add(new ForkStatement(
                        HardCodedPrograms.createTreeStatement(
                                new ArrayList<>() {{
                                    add(new AcquireStatement("cnt"));
                                    add(new WriteHeapStatement("v1", new ArithmeticExpression(
                                            ArithmeticExpression.Operations.MULTIPLICATION,
                                            new ValueExpression(new IntValue(10)),
                                            new ReadHeapExpression(new VariableExpression("v1"))
                                        )
                                    ));
                                    add(new WriteHeapStatement("v1", new ArithmeticExpression(
                                            ArithmeticExpression.Operations.MULTIPLICATION,
                                            new ValueExpression(new IntValue(2)),
                                            new ReadHeapExpression(new VariableExpression("v1"))
                                        )
                                    ));
                                    add(new PrintStatement(new ReadHeapExpression(new VariableExpression("v1"))));
                                    add(new ReleaseStatement("cnt"));
                                }}
                        ))
                );
                add(new AcquireStatement("cnt"));
                add(new PrintStatement( new ArithmeticExpression(
                        ArithmeticExpression.Operations.MINUS,
                        new ReadHeapExpression(new VariableExpression("v1")),
                        new ValueExpression(new IntValue(1))
                    )
                ));
                add(new ReleaseStatement("cnt"));
            }}
    );

}
