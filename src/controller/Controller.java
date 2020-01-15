package controller;

import controller.garbage_collector.GarbageCollector;
import model.ProgramState;
import model.values.Value;
import repository.IStateRepository;
import utils.exceptions.ThreadError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Controller {

    private IStateRepository stateRepository;
    private ExecutorService executor = null;

    public Controller(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
        executor = Executors.newFixedThreadPool(3);
    }

    //public void allStep() {
    //    ProgramState currentProgram = stateRepository.getCurrentProgram();
    //    stateRepository.logCurrentProgramStateExecution(currentProgram);
    //    while (!currentProgram.getExecutionStack().isEmpty()) {
    //        currentProgram.oneStep();
    //        stateRepository.logCurrentProgramStateExecution(currentProgram);
    //        // TODO: rewrite the GarbageCollector call nicer
    //        // TODO: such as: GarbageCollector.applyGarbageCollectorTo(currentProgram)
    //        // run the garbage collector
    //        currentProgram.getHeap().setContent(
    //                GarbageCollector.unsafeGarbageCollector(
    //                        GarbageCollector.getAddressesFromSymbolTable(
    //                           currentProgram.getSymbolsTable().getContent().values()
    //                        ),
    //                       GarbageCollector.getAddressesFromHeapCells(
    //                               currentProgram.getHeap().getContent().values()
    //                       ),
    //                       currentProgram.getHeap().getContent()
    //                )
    //        );
    //        stateRepository.logGarbageCollectorHasBeenApplied();
    //        stateRepository.logCurrentProgramStateExecution(currentProgram);
    //    }
    //}

    public void oneStepForAll() {
        List<ProgramState> programStateList = this.removeCompletedPrograms(stateRepository.getProgramStatesList());

        if (programStateList.size() == 0) {
            throw new RuntimeException("no more programs");
        }

        // HERE you can call conservativeGarbageCollector
        Map<Integer, Value> newHeap = GarbageCollector.unsafeGarbageCollector(
                GarbageCollector.getAddressesFromSymbolTable(
                        GarbageCollector.getAllSymbols(programStateList)
                ),
                GarbageCollector.getAddressesFromHeapCells(
                        programStateList.get(0).getHeap().getContent().values()
                ),
                programStateList.get(0).getHeap().getContent()
        );
        //
        programStateList.forEach(item -> item.getHeap().setContent(newHeap));

        // on step for all
        this.oneStepForAllPrg(programStateList);
    }

    private void oneStepForAllPrg(List<ProgramState> programStateList) {
        // before the execution, print the programStateList into the log file
        programStateList.forEach(prg -> stateRepository.logCurrentProgramStateExecution(prg));

        // RUN concurrently one step for each of the existing PrgStates

        // prepare the list of callable objects
        // in other words, we map each programState into a callable(object for multithreading)
        List<Callable<ProgramState>> callableListOfProgramStates = programStateList
                .stream()
                .map(programState -> {
                    Callable<ProgramState> callable = () -> {
                        return programState.oneStep();
                    };
                    return callable;
                })
                .collect(Collectors.toList());

        // start the execution of the callable objects
        // it returns the list of new created PrgStates (namely threads)
        List<ProgramState> newPrgList;
        try {
            newPrgList = executor.invokeAll(callableListOfProgramStates)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new ThreadError(e.getMessage());
                        }
                    })
                    .filter(p -> p != null)
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            throw new ThreadError(e.getMessage());
        }

        // add the new created threads to the list of existing threads
        programStateList.addAll(newPrgList);

        // Save the current programs in the repository
        stateRepository.setProgramStatesList(programStateList);

        //
        stateRepository.updateDataProgramState();

        // after the execution, print the PrgState List into the log file
        programStateList.forEach(prg -> stateRepository.logCurrentProgramStateExecution(prg));
    }

    synchronized public void allStep() {
        List<ProgramState> completedPrograms = new ArrayList<>();

        //remove the completed programs
        List<ProgramState> programStateList = this.removeCompletedPrograms(stateRepository.getProgramStatesList());

        while(programStateList.size() > 0) {
            // HERE you can call conservativeGarbageCollector
            Map<Integer, Value> newHeap = GarbageCollector.unsafeGarbageCollector(
                    GarbageCollector.getAddressesFromSymbolTable(
                            GarbageCollector.getAllSymbols(programStateList)
                    ),
                    GarbageCollector.getAddressesFromHeapCells(
                        programStateList.get(0).getHeap().getContent().values()
                    ),
                    programStateList.get(0).getHeap().getContent()
            );
            //
            programStateList.forEach(item -> item.getHeap().setContent(newHeap));


            // on step for all
            this.oneStepForAllPrg(programStateList);

            // get completed programs
            this.getCompletedPrograms(programStateList).forEach(p -> completedPrograms.add(p));
            // or this one:
            // completedPrograms.addAll(this.getCompletedPrograms(programStateList));

            // remove the completed programs
            programStateList = this.removeCompletedPrograms(stateRepository.getProgramStatesList());
        }

        executor.shutdownNow();

        // HERE the repository still contains at least one Completed Prg
        // and its List<PrgState> is not empty. Note that oneStepForAllPrg calls the method
        // setPrgList of repository in order to change the repository
        // update the repository state
        stateRepository.setProgramStatesList(programStateList);

        // we print the final result of each thread
        completedPrograms.forEach(System.out::println);
    }

    public void addProgram(ProgramState programState) {
        stateRepository.addProgramState(programState);
     }

    private List<ProgramState> removeCompletedPrograms(List<ProgramState> inProgramList) {
        return inProgramList.stream()
                 .filter(p -> p.isNotCompleted()) // or .filter(ProgramState::isNotCompleted)
                .collect(Collectors.toList());
    }

    private List<ProgramState> getCompletedPrograms(List<ProgramState> inProgramList) {
        return inProgramList.stream()
                .filter(p -> !p.isNotCompleted())
                .collect(Collectors.toList());
    }

    public IStateRepository getStateRepository() {
        return stateRepository;
    }
}
