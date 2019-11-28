package repository;

import controller.garbage_collector.GarbageCollector;
import model.ProgramState;
import utils.exceptions.IOError;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StateRepository implements IStateRepository {

    private String logFilePath;
    private PrintWriter logFile;
    private ArrayList<ProgramState> states;

    public StateRepository(String logFilePath) {
        states = new ArrayList<>();
        this.logFilePath = "src\\resources\\out\\logs\\" + logFilePath;
        this.setUpPrinterWriter();
    }

    public StateRepository() {
        states = new ArrayList<>();
        this.logFilePath = "src\\resources\\out\\logs\\DefaultLogFile.txt";
        this.setUpPrinterWriter();
    }

    @Override
    public void addProgramState(ProgramState programState) {
        states.add(programState);
    }

    @Override
    public ProgramState getCurrentProgram() {
        return states.get(states.size() - 1);
    }

    @Override
    public void logCurrentProgramStateExecution() {
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        } catch (IOException error) {
            throw new IOError(error.getMessage());
        }
        logFile.println(states.get(states.size() - 1));
        logFile.close();
    }

    @Override
    public void logGarbageCollectorHasBeenApplied() {
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        } catch (IOException error) {
            throw new IOError(error.getMessage());
        }
        logFile.println("GarbageCollector has been applied");
        logFile.close();
    }

    private String getCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    private void setUpPrinterWriter() {
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath)));
            logFile.flush();
            logFile.println(this.getCurrentTime() + "\n");
        } catch (IOException error) {
            throw new IOError(error.getMessage());
        }
        logFile.close();
    }
}
