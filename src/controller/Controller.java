package controller;

import utils.exceptions.*;
import model.ProgramState;
import model.statements.Statement;
import repository.IStateRepository;
import utils.collections.stack.IMyStack;

public class Controller {

    private IStateRepository stateRepository;

    public Controller(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

     private void oneStep(ProgramState programState) {
        IMyStack<Statement> statements = programState.getExecutionStack();
        if (statements.isEmpty()) {
            throw new NoMoreStatements("no more statements: execution stack is empty");
        }
        Statement currentStatement = statements.pop();
        currentStatement.execute(programState);
     }

     public void allStep() {
         ProgramState currentProgram = stateRepository.getCurrentProgram();
         System.out.println(currentProgram.toString());
         while (!currentProgram.getExecutionStack().isEmpty()) {
             oneStep(currentProgram);
             System.out.println(currentProgram.toString());
         }
     }

     public void addProgram(ProgramState programState) {
        stateRepository.addProgramState(programState);
     }

}
