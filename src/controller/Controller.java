package controller;

import controller.garbage_collector.GarbageCollector;
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
             // TODO: rewrite the GarbageCollector call nicer
             // TODO: such as: GarbageCollector.applyGarbageCollectorTo(currentProgram)
             currentProgram.getHeap().setContent(
                     GarbageCollector.unsafeGarbageCollector(
                             GarbageCollector.getAddressesFromSymbolTable(
                                currentProgram.getSymbolsTable().getContent().values()
                             ),
                            GarbageCollector.getAddressesFromHeapCells(
                                    currentProgram.getHeap().getContent().values()
                            ),
                            currentProgram.getHeap().getContent()
                     )
             );
             stateRepository.logCurrentProgramStateExecution();
         }
     }

     public void addProgram(ProgramState programState) {
        stateRepository.addProgramState(programState);
     }

}
