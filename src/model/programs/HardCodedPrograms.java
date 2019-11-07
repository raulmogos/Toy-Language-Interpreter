package model.programs;

import model.statements.Statement;


public class HardCodedPrograms {

    public static Statement getProgramByIndex(int index) throws Exception {
        switch (index) {
            case 1:
                return Programs.program_1;
            case 2:
                return Programs.program_2;
            case 3:
                return Programs.program_3;
            default:
                throw new Exception("no index provided");
        }
    }
}
