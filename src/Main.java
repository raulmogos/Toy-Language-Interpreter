import controller.Controller;
import repository.IStateRepository;
import repository.StateRepository;
import view.View;


public class Main {
    public static void main(String[] argv) {
        IStateRepository repo = new StateRepository();
        Controller ctrl = new Controller(repo);
        View view = new View(ctrl);

        view.start();
    }
}