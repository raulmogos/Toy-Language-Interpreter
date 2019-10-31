package controller;

import model.ProgramState;
import model.statements.Statement;
import repository.IStateRepository;
import utils.exceptions.*;
import model.execution_stack.IExecutionStack;

public class Controller {

    private IStateRepository stateRepository;

    public Controller(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

     public ProgramState oneStep(ProgramState programState)
             throws NoMoreStatements, TypeError, LogicExpressionError, DoesNotExistError, DoesAlreadyExist
     {
        IExecutionStack<Statement> statements = programState.getStatements();
        if (statements.isEmpty()) throw new NoMoreStatements("no more statements");
        Statement currentStatement = statements.pop();
        return currentStatement.execute(programState);
     }

     public void allStep()
             throws DoesNotExistError, NoMoreStatements, LogicExpressionError, TypeError, DoesAlreadyExist
     {
         ProgramState currentProgram = stateRepository.getCurrentProgram();
         System.out.println(currentProgram.toString());
         while (!currentProgram.getStatements().isEmpty()) {
             oneStep(currentProgram);
             System.out.println(currentProgram.toString());
         }
     }

}
