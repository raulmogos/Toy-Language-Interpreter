import controller.Controller;
import model.ProgramState;
import utils.collections.stack.MyStack;
import utils.collections.stack.IMyStack;
import utils.collections.list.IMyList;
import utils.collections.list.MyList;
import model.programs.HardCodedPrograms;
import model.statements.Statement;
import utils.collections.map.IMyMap;
import utils.collections.map.MyMap;
import model.values.Value;
import repository.IStateRepository;
import repository.StateRepository;

public class Main {
    public static void main(String[] argv) {
        System.out.println("start");

        IStateRepository repo = new StateRepository();
        Controller ctrl = new Controller(repo);

        try {

            Statement program = HardCodedPrograms.getProgramByIndex(2);

            IMyStack<Statement> statements = new MyStack<>();
            IMyMap<String, Value > symbols = new MyMap<>();
            IMyList<Value> output = new MyList<>();

            repo.addProgramState(new ProgramState(statements, symbols, output, program));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            ctrl.allStep();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}