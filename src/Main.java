import controller.Controller;
import model.ProgramState;
import resources.in.programs.Programs;
import model.statements.Statement;
import model.values.StringValue;
import model.values.Value;
import repository.IStateRepository;
import repository.StateRepository;
import utils.collections.heap.IMyHeap;
import utils.collections.heap.MyHeap;
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
        IMyHeap<Integer, Value> heap1 = new MyHeap<>();
        ProgramState prg1 = new ProgramState(statements1, symbols1, output1, fileTable1, heap1, ex1);
        IStateRepository repo1 = new StateRepository("log1.txt");
        repo1.addProgramState(prg1);
        Controller ctr1 = new Controller(repo1);

        Statement ex2 = Programs.program_2;
        IMyStack<Statement> statements2 = new MyStack<>();
        IMyMap<String, Value> symbols2 = new MyMap<>();
        IMyList<Value> output2 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable2 = new MyMap<>();
        IMyHeap<Integer, Value> heap2 = new MyHeap<>();
        ProgramState prg2 = new ProgramState(statements2, symbols2, output2, fileTable2, heap2, ex2);
        IStateRepository repo2 = new StateRepository("log2.txt");
        repo2.addProgramState(prg2);
        Controller ctr2 = new Controller(repo2);

        Statement ex3 = Programs.program_3;
        IMyStack<Statement> statements3 = new MyStack<>();
        IMyMap<String, Value> symbols3 = new MyMap<>();
        IMyList<Value> output3 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable3 = new MyMap<>();
        IMyHeap<Integer, Value> heap3 = new MyHeap<>();
        ProgramState prg3 = new ProgramState(statements3, symbols3, output3, fileTable3, heap3, ex3);
        IStateRepository repo3 = new StateRepository("log3.txt");
        repo3.addProgramState(prg3);
        Controller ctr3 = new Controller(repo3);

        Statement ex4 = Programs.program_4;
        IMyStack<Statement> statements4 = new MyStack<>();
        IMyMap<String, Value> symbols4 = new MyMap<>();
        IMyList<Value> output4 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable4 = new MyMap<>();
        IMyHeap<Integer, Value> heap4 = new MyHeap<>();
        ProgramState prg4 = new ProgramState(statements4, symbols4, output4, fileTable4, heap4, ex4);
        IStateRepository repo4 = new StateRepository("log4.txt");
        repo4.addProgramState(prg4);
        Controller ctr4 = new Controller(repo4);

        Statement ex5 = Programs.program_5;
        IMyStack<Statement> statements5 = new MyStack<>();
        IMyMap<String, Value> symbols5 = new MyMap<>();
        IMyList<Value> output5 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable5 = new MyMap<>();
        IMyHeap<Integer, Value> heap5 = new MyHeap<>();
        ProgramState prg5 = new ProgramState(statements5, symbols5, output5, fileTable5, heap5, ex5);
        IStateRepository repo5 = new StateRepository("log5.txt");
        repo5.addProgramState(prg5);
        Controller ctr5 = new Controller(repo5);

        Statement ex6 = Programs.program_6;
        IMyStack<Statement> statements6 = new MyStack<>();
        IMyMap<String, Value> symbols6 = new MyMap<>();
        IMyList<Value> output6 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable6 = new MyMap<>();
        IMyHeap<Integer, Value> heap6 = new MyHeap<>();
        ProgramState prg6 = new ProgramState(statements6, symbols6, output6, fileTable6, heap6, ex6);
        IStateRepository repo6 = new StateRepository("log6.txt");
        repo6.addProgramState(prg6);
        Controller ctr6 = new Controller(repo6);

        Statement ex7 = Programs.program_7;
        IMyStack<Statement> statements7 = new MyStack<>();
        IMyMap<String, Value> symbols7 = new MyMap<>();
        IMyList<Value> output7 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable7 = new MyMap<>();
        IMyHeap<Integer, Value> heap7 = new MyHeap<>();
        ProgramState prg7 = new ProgramState(statements7, symbols7, output7, fileTable7, heap7, ex7);
        IStateRepository repo7 = new StateRepository("log7.txt");
        repo7.addProgramState(prg7);
        Controller ctr7 = new Controller(repo7);

        Statement ex8 = Programs.program_8;
        IMyStack<Statement> statements8 = new MyStack<>();
        IMyMap<String, Value> symbols8 = new MyMap<>();
        IMyList<Value> output8 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable8 = new MyMap<>();
        IMyHeap<Integer, Value> heap8 = new MyHeap<>();
        ProgramState prg8 = new ProgramState(statements8, symbols8, output8, fileTable8, heap8, ex8);
        IStateRepository repo8 = new StateRepository("log8.txt");
        repo8.addProgramState(prg8);
        Controller ctr8 = new Controller(repo8);

        Statement ex9 = Programs.program_9;
        IMyStack<Statement> statements9 = new MyStack<>();
        IMyMap<String, Value> symbols9 = new MyMap<>();
        IMyList<Value> output9 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable9 = new MyMap<>();
        IMyHeap<Integer, Value> heap9 = new MyHeap<>();
        ProgramState prg9 = new ProgramState(statements9, symbols9, output9, fileTable9, heap9, ex9);
        IStateRepository repo9 = new StateRepository("log9.txt");
        repo9.addProgramState(prg9);
        Controller ctr9 = new Controller(repo9);

        Statement ex10 = Programs.program_10;
        IMyStack<Statement> statements10 = new MyStack<>();
        IMyMap<String, Value> symbols10 = new MyMap<>();
        IMyList<Value> output10 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable10 = new MyMap<>();
        IMyHeap<Integer, Value> heap10 = new MyHeap<>();
        ProgramState prg10 = new ProgramState(statements10, symbols10, output10, fileTable10, heap10, ex10);
        IStateRepository repo10 = new StateRepository("log10.txt");
        repo10.addProgramState(prg10);
        Controller ctr10 = new Controller(repo10);

        Statement ex11 = Programs.program_11;
        IMyStack<Statement> statements11 = new MyStack<>();
        IMyMap<String, Value> symbols11 = new MyMap<>();
        IMyList<Value> output11 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable11 = new MyMap<>();
        IMyHeap<Integer, Value> heap11 = new MyHeap<>();
        ProgramState prg11 = new ProgramState(statements11, symbols11, output11, fileTable11, heap11, ex11);
        IStateRepository repo11 = new StateRepository("log11.txt");
        repo11.addProgramState(prg11);
        Controller ctr11 = new Controller(repo11);

        Statement ex12 = Programs.program_12;
        IMyStack<Statement> statements12 = new MyStack<>();
        IMyMap<String, Value> symbols12 = new MyMap<>();
        IMyList<Value> output12 = new MyList<>();
        IMyMap<StringValue, BufferedReader> fileTable12 = new MyMap<>();
        IMyHeap<Integer, Value> heap12 = new MyHeap<>();
        ProgramState prg12 = new ProgramState(statements12, symbols12, output12, fileTable12, heap12, ex12);
        IStateRepository repo12 = new StateRepository("log12.txt");
        repo12.addProgramState(prg12);
        Controller ctr12 = new Controller(repo12);


        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctr1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctr2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctr3));
        menu.addCommand(new RunExample("4",ex4.toString(),ctr4));
        menu.addCommand(new RunExample("5",ex5.toString(),ctr5));
        menu.addCommand(new RunExample("6",ex6.toString(),ctr6));
        menu.addCommand(new RunExample("7",ex7.toString(),ctr7));
        menu.addCommand(new RunExample("8",ex8.toString(),ctr8));
        menu.addCommand(new RunExample("9",ex9.toString(),ctr9));
        menu.addCommand(new RunExample("10",ex10.toString(),ctr10));
        menu.addCommand(new RunExample("11",ex11.toString(),ctr11));
        menu.addCommand(new RunExample("12",ex12.toString(),ctr12));
        menu.show();
    }
}