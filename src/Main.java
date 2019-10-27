public class Main {
    public static void main(String[] argv) {
        System.out.println("start");
    }
}

/*
IStmt ex1= new CompStmt(new VarDeclareStmt("v",new IntType()),
            new CompStmt(new AssignStmt("v",
            new ValueExp(new IntValue(2))),
            new PrintStmt(new VarExp("v"))))
*/