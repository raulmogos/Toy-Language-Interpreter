package resources.in.programs;

import model.statements.CompoundStatement;
import model.statements.Statement;

import java.util.ArrayList;


public class HardCodedPrograms {

    public static Statement getProgramByIndex(int index) {
        switch (index) {
            case 1:
                return Programs.program_1;
            case 2:
                return Programs.program_2;
            case 3:
                return Programs.program_3;
            case 4:
                return Programs.program_4;
            case 5:
                return Programs.program_5;
            case 6:
                return Programs.program_6;
            case 7:
                return Programs.program_7;
            case 8:
                return Programs.program_8;
            case 9:
                return Programs.program_9;
            case 10:
                return Programs.program_10;
            case 11:
                return Programs.program_11;
            case 12:
                return Programs.program_12;
            case 13:
                return Programs.program_13;
            case 14:
                return Programs.program_14;
            default:
                throw new RuntimeException("no index provided");
        }
    }

    // TODO
    public static Statement createTreeStatement(ArrayList<Statement> statements) {
        int size = statements.size();
        if ( size == 1 ) {
            return statements.get(0);
        }
        return new CompoundStatement(statements.get(0), createTreeStatement(new ArrayList<>(statements.subList(1, size))));
    }
}
