package model.statements;

import model.ProgramState;
import model.expressions.Expression;
import model.expressions.VariableExpression;
import model.expressions.relational_expressions.IsLessThanRelationalExpression;
import model.types.BoolType;
import model.types.IntType;
import model.types.Type;
import resources.in.programs.HardCodedPrograms;
import utils.collections.map.IMyMap;
import utils.exceptions.TypeError;

import java.util.ArrayList;

public class ForStatement implements Statement {

    private Expression firstExpression;
    private Expression secondExpression;
    private Expression thirdExpression;
    private Statement statement;

    public ForStatement(Expression firstExpression, Expression secondExpression, Expression thirdExpression, Statement statement) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.thirdExpression = thirdExpression;
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState state) {

        Statement st = HardCodedPrograms.createTreeStatement(new ArrayList<>() {{
            add(new VariableDeclarationStatement("v", new IntType()));
            add(new AssignmentStatement("v", firstExpression));
            add(new WhileStatement(
                    new IsLessThanRelationalExpression(new VariableExpression("v"), secondExpression),
                    new CompoundStatement(
                            statement,
                            new AssignmentStatement("v", thirdExpression)
                    )
            ));
        }});
        state.getExecutionStack().push(st);
        return null;
    }

    @Override
    public IMyMap<String, Type> typeCheck(IMyMap<String, Type> typeEnvironment) {
        typeEnvironment.put("v", new IntType());
        Type firstExpressionType = firstExpression.typeCheck(typeEnvironment);
        Type secondExpressionType = secondExpression.typeCheck(typeEnvironment);
        Type thirdExpressionType = thirdExpression.typeCheck(typeEnvironment);
        if (!firstExpressionType.equals(new IntType())) {
            throw new TypeError("ForStatement: 1 should be int");
        }
        if (!secondExpressionType.equals(new IntType())) {
            throw new TypeError("ForStatement: 2 should be int");
        }
        if (!thirdExpressionType.equals(new IntType())) {
            throw new TypeError("ForStatement: 3 should be int");
        }
        return typeEnvironment;
    }

    @Override
    public String toString() {
        return "FOR( " + "v=" + firstExpression + "; v<" + secondExpression + "; v=" + thirdExpression + " ) { " + statement + " }";
    }
}
