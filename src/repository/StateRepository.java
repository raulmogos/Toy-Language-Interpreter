package repository;

import model.ProgramState;
import utils.exceptions.IOError;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StateRepository implements IStateRepository {

    private String logFilePath;
    private PrintWriter logFile;
    private ArrayList<ProgramState> states;

    private String outputCurrentString;
    private HashMap<Integer, String> stackCurrentStringMap;
    private String heapCurrentString;
    private HashMap<Integer, String> symbolsCurrentStringMap;

    private String filesCurrentString;

    public StateRepository(String logFilePath) {
        states = new ArrayList<>();
        this.logFilePath = "src\\resources\\out\\logs\\" + logFilePath;
        this.setUpPrinterWriter();
        stackCurrentStringMap = new HashMap<>();
        symbolsCurrentStringMap = new HashMap<>();
    }

    public StateRepository() {
        states = new ArrayList<>();
        this.logFilePath = "src\\resources\\out\\logs\\DefaultLogFile.txt";
        this.setUpPrinterWriter();
        stackCurrentStringMap = new HashMap<>();
        symbolsCurrentStringMap = new HashMap<>();
    }

    @Override
    public void addProgramState(ProgramState programState) {
        states.add(programState);
    }

    // TODO: REMOVE THIS WHEN IT IS NO LONGER USED
    @Override
    public ProgramState getCurrentProgram() {
        return states.get(states.size() - 1);
    }

    @Override
    public void logCurrentProgramStateExecution(ProgramState programState) {
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        } catch (IOException error) {
            throw new IOError(error.getMessage());
        }
        logFile.println(programState);
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

    @Override
    public List<ProgramState> getProgramStatesList() {
        return this.states;
    }

    @Override
    public void setProgramStatesList(List<ProgramState> programStatesList) {
        this.states = (ArrayList<ProgramState>) programStatesList;
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

    private String getCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    public void updateDataProgramState() {
        outputCurrentString = states.size() != 0 ? states.get(0).getOutput().toString() : "";
        states.forEach(s -> stackCurrentStringMap.put(s.getId(), s.getExecutionStack().toString()));
        heapCurrentString = states.size() != 0 ? states.get(0).getHeap().toString() : "";
        states.forEach(s -> symbolsCurrentStringMap.put(s.getId(), s.getSymbolsTable().toString()));
        filesCurrentString = states.size() != 0 ? states.get(0).getFileTable().toString() : "";
    }

    public String getOutputCurrentString() {
        return outputCurrentString;
    }

    public String getStackCurrentString(int id) {
        return stackCurrentStringMap.get(id);
    }

    public String getHeapCurrentString() {
        return heapCurrentString;
    }

    public String getCodeCurrentString() {
        return states.get(0).getExecutionStack().toString();
    }

    public String getSymbolsCurrentString(int id) {
        return symbolsCurrentStringMap.get(id);
    }

    public String getFilesCurrentString() {
        return filesCurrentString;
    }
}
