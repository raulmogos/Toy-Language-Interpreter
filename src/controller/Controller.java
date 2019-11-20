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
            throw new NoMoreStatementsError("no more statements: execution stack is empty");
        }
        Statement currentStatement = statements.pop();
        currentStatement.execute(programState);
     }

     public void allStep() {
         ProgramState currentProgram = stateRepository.getCurrentProgram();
         stateRepository.logCurrentProgramStateExecution();
         while (!currentProgram.getExecutionStack().isEmpty()) {
             oneStep(currentProgram);
             stateRepository.logCurrentProgramStateExecution();
         }
     }

     public void addProgram(ProgramState programState) {
        stateRepository.addProgramState(programState);
     }

}
