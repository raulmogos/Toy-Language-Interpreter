import controller.Controller;
import model.ProgramState;
import model.execution_stack.ExecutionStack;
import model.execution_stack.IExecutionStack;
import model.output.IOutput;
import model.output.Output;
import model.programs.HardCodedPrograms;
import model.statements.Statement;
import model.symbol_table.ISymbolTable;
import model.symbol_table.SymbolTable;
import model.values.Value;
import repository.IStateRepository;
import repository.StateRepository;

public class Main {
    public static void main(String[] argv) {
        System.out.println("start");

        IStateRepository repo = new StateRepository();
        Controller ctrl = new Controller(repo);

        Statement program = HardCodedPrograms.getProgramByIndex(1);


        IExecutionStack<Statement> statements = new ExecutionStack<>();
        ISymbolTable<String, Value > symbols = new SymbolTable<>();
        IOutput<Value> output = new Output<>();

        repo.addProgramState(new ProgramState(statements, symbols, output, program));

        try {
            ctrl.allStep();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}