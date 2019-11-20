import controller.Controller;
import model.ProgramState;
import resources.in.programs.Programs;
import model.statements.Statement;
import model.values.StringValue;
import model.values.Value;
import repository.IStateRepository;
import repository.StateRepository;
import utils.collections.list.IMyList;
import utils.collections.list.MyList;
import utils.collections.map.IMyMap;
import utils.collections.map.MyMap;
import utils.collections.stack.IMyStack;
import utils.collections.stack.MyStack;
import view.TextMenu;
import view.commands.ExitCommand;
import view.commands.RunExample;

import java.io.BufferedReader;


public class Main {
    public static void main(String[] argv) {
//        IStateRepository repo = new StateRepository("ProgramStateExecution.txt");
//        Controller ctrl = new Controller(repo);
//        View view = new View(ctrl);
//
//        view.start();


        Statement ex1 = Programs.program_1;
        IMyStack<Statement> statements1 = new MyStack<>();
        IMyMap<String, Value> symbols1 = new MyMap<>();
        IMyList<Value> output1 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable1 = new MyMap<>();
        ProgramState prg1 = new ProgramState(statements1, symbols1, output1, fileTable1, ex1);
        IStateRepository repo1 = new StateRepository("log1.txt");
        repo1.addProgramState(prg1);
        Controller ctr1 = new Controller(repo1);

        Statement ex2 = Programs.program_2;
        IMyStack<Statement> statements2 = new MyStack<>();
        IMyMap<String, Value> symbols2 = new MyMap<>();
        IMyList<Value> output2 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable2 = new MyMap<>();
        ProgramState prg2 = new ProgramState(statements2, symbols2, output2, fileTable2, ex2);
        IStateRepository repo2 = new StateRepository("log2.txt");
        repo2.addProgramState(prg2);
        Controller ctr2 = new Controller(repo2);

        Statement ex3 = Programs.program_3;
        IMyStack<Statement> statements3 = new MyStack<>();
        IMyMap<String, Value> symbols3 = new MyMap<>();
        IMyList<Value> output3 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable3 = new MyMap<>();
        ProgramState prg3 = new ProgramState(statements3, symbols3, output3, fileTable3, ex3);
        IStateRepository repo3 = new StateRepository("log3.txt");
        repo3.addProgramState(prg3);
        Controller ctr3 = new Controller(repo3);

        Statement ex4 = Programs.program_4;
        IMyStack<Statement> statements4 = new MyStack<>();
        IMyMap<String, Value> symbols4 = new MyMap<>();
        IMyList<Value> output4 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable4 = new MyMap<>();
        ProgramState prg4 = new ProgramState(statements4, symbols4, output4, fileTable4, ex4);
        IStateRepository repo4 = new StateRepository("log4.txt");
        repo4.addProgramState(prg4);
        Controller ctr4 = new Controller(repo4);

        Statement ex5 = Programs.program_5;
        IMyStack<Statement> statements5 = new MyStack<>();
        IMyMap<String, Value> symbols5 = new MyMap<>();
        IMyList<Value> output5 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable5 = new MyMap<>();
        ProgramState prg5 = new ProgramState(statements5, symbols5, output5, fileTable5, ex5);
        IStateRepository repo5 = new StateRepository("log5.txt");
        repo5.addProgramState(prg5);
        Controller ctr5 = new Controller(repo5);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctr1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctr2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctr3));
        menu.addCommand(new RunExample("4",ex4.toString(),ctr4));
        menu.addCommand(new RunExample("5",ex5.toString(),ctr5));
        menu.show();
    }
}