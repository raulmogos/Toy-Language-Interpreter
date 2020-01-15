package view.console;

import controller.Controller;
import model.ProgramState;
import resources.in.programs.HardCodedPrograms;
import resources.in.programs.Programs;
import model.statements.Statement;
import model.values.StringValue;
import model.values.Value;
import utils.collections.heap.IMyHeap;
import utils.collections.heap.MyHeap;
import utils.collections.list.IMyList;
import utils.collections.list.MyList;
import utils.collections.map.IMyMap;
import utils.collections.map.MyMap;
import utils.collections.stack.IMyStack;
import utils.collections.stack.MyStack;

import java.io.BufferedReader;
import java.util.Scanner;

public class View {

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void start () {
        System.out.println("start:\n");
        System.out.println("input a number from 1 to " + Programs.NUMBER_OF_PROGRAMS);
        Scanner scanner = new Scanner(System.in);
        try{
            int input = scanner.nextInt();
            Statement program = HardCodedPrograms.getProgramByIndex(input);
            IMyStack<Statement> statements = new MyStack<>();
            IMyMap<String, Value> symbols = new MyMap<>();
            IMyList<Value> output = new MyList<>();
            IMyMap<StringValue, BufferedReader> fileTable = new MyMap<>();
            IMyHeap<Integer, Value> heap = new MyHeap<>();
            controller.addProgram(new ProgramState(statements, symbols, output, fileTable, heap, program));
            controller.allStep();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
