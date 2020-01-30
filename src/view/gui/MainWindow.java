package view.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import controller.Controller;
import utils.exceptions.SelectionError;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class MainWindow extends Application {

    private static ArrayList<TupleItem> controllers = new ArrayList<>();
    private static TableView<TupleItem> tableView;
    private static TableView<IdClass> programStates;
    private static TextArea codeText;
    private static TextArea stackText;
    private static TextArea outputText;
    private static TextArea heapText;
    private static TextArea symbolsText;
    private static TextArea FilesText;
    private static TextArea LockTableText;
    private static Label labelSelectedProgramState;

    private static IdClass selectedProgramState;

    public static void addController(String id, String programString, Controller controller) {
        TupleItem tupleItem = new TupleItem(id, programString, controller);
        controllers.add(tupleItem);
    }

    private TableView<TupleItem> setUpProgramsList() {
        // int the TableView list
        tableView = new TableView<>();

        // only one item can be selected
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // create the columns
        TableColumn<TupleItem, String> columnId = new TableColumn<>("id");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<TupleItem, String> columnProgramString = new TableColumn<>("code");
        columnProgramString.setCellValueFactory(new PropertyValueFactory<>("programString"));
        tableView.getColumns().add(columnId);
        tableView.getColumns().add(columnProgramString);
        // populate the table
        controllers.forEach(c -> tableView.getItems().add(c));
        // action
        tableView.setOnMouseClicked(value -> {
            TupleItem item = tableView.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new SelectionError("no item was selected");
            }
            selectedProgramState = programStates.getSelectionModel().getSelectedItem();
            if (selectedProgramState != null) {
                labelSelectedProgramState.setText("selected:   " + selectedProgramState.getId());
            }            // code
            String codeText = item.getController().getStateRepository().getCodeCurrentString();
            this.updateCodeArea(codeText.replace("; ", ";\n\n"));

            // output area
            this.updateOutputArea("");
            this.updateStackArea("");
            this.updateHeapArea("");
            this.updateSymbolsArea("");
            this.updateFilesArea("");
            this.updateLockTableArea("");

            this.updateProgramsStates(item);
        });

        tableView.setStyle("height: 100%; width: 100%");
        return tableView;
    }

    private TableView<IdClass> setUpProgramStates() {
        programStates = new TableView<>();
        programStates.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        TableColumn<IdClass, String> columnId = new TableColumn<>("id");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        programStates.getColumns().add(columnId);
        programStates.setOnMouseClicked(value -> {
            selectedProgramState = programStates.getSelectionModel().getSelectedItem();
            if (selectedProgramState != null) {
                labelSelectedProgramState.setText("selected:   " + selectedProgramState.getId());
            }
            TupleItem item = tableView.getSelectionModel().getSelectedItem();
            this.updateIndependentResources(selectedProgramState, item);
            updateProgramsStates(item);
        });
        return programStates;
    }

    private void updateIndependentResources(IdClass id, TupleItem item) {
        // stack area
        String stackText = item.getController().getStateRepository().getStackCurrentString(id.getId());
        this.updateStackArea(stackText);
        // symbols
        String symbolsText = item.getController().getStateRepository().getSymbolsCurrentString(id.getId());
        this.updateSymbolsArea(symbolsText);
    }

    private void updateProgramsStates(TupleItem item) {
        programStates.getItems().clear();
        item.getController().getStateRepository().getProgramStatesList()
                .forEach(s -> programStates.getItems().add(new IdClass(s.getId())));
        selectedProgramState = selectedProgramState == null ? programStates.getItems().get(0) : selectedProgramState;
    }

    private TextArea setUpCodeArea() {
        codeText = new TextArea();
        codeText.setStyle("height: 100%; width: 100%");
        codeText.setEditable(false);
        return codeText;
    }


    private void updateCodeArea(String text) {
        codeText.clear();
        codeText.setText(text);
    }

    private Label setUpNumberLabel() {
        Label label = new Label();
        label.setText("number of programs: " + Integer.toString(controllers.size()));
        return label;
    }

    private Button setUpRunAllButton() {
        Button button = new Button("Run All");
        button.setOnAction(value ->  {
            TupleItem item = tableView.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new SelectionError("no item was selected");
            }
            // run
            System.out.println("ALL step for --- " + item.getId());
            item.getController().allStep();

            this.updateAllSharedResources(item);

            IdClass id = selectedProgramState;
            if (id == null) {
                throw new SelectionError("no id selected");
            }
            this.updateIndependentResources(id, item);
        });
        return button;
    }

    private Button setUpRunOneStepForAllButton() {
        Button button = new Button("Run One Step");
        button.setOnAction(value ->  {
            TupleItem item = tableView.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new SelectionError("no item was selected");
            }
            System.out.println("ONE step for --- " + item.getId());
            item.getController().oneStepForAll();
            this.updateAllSharedResources(item);
            IdClass id = selectedProgramState;
            if (id == null) {
                throw new SelectionError("no id selected");
            }
            this.updateIndependentResources(id, item);
        });
        return button;
    }

    private VBox setUpAllStackArea() {
        VBox layout = new VBox();

        Label label = new Label("Stack: ");
        stackText = new TextArea();

        layout.getChildren().add(label);
        layout.getChildren().add(stackText);
        return layout;
    }

    private void updateStackArea(String text) {
        stackText.clear();
        stackText.setText(text);
    }

    private VBox setUpAllOutputArea() {
        VBox layout = new VBox();

        Label label = new Label("Output console: ");
        outputText = new TextArea();

        layout.getChildren().add(label);
        layout.getChildren().add(outputText);
        return layout;
    }

    private void updateOutputArea(String text) {
        outputText.clear();
        outputText.setText(text);
    }

    private VBox setUpHeapArea() {
        VBox layout = new VBox();

        Label label = new Label("Heap: ");
        heapText = new TextArea();

        layout.getChildren().add(label);
        layout.getChildren().add(heapText);
        return layout;
    }

    private void updateHeapArea(String text) {
        heapText.clear();
        heapText.setText(text);
    }

    private VBox setUpSymbolsArea() {
        VBox layout = new VBox();

        Label label = new Label("Symbols: ");
        symbolsText = new TextArea();

        layout.getChildren().add(label);
        layout.getChildren().add(symbolsText);
        return layout;
    }

    private void updateSymbolsArea(String text) {
        symbolsText.clear();
        symbolsText.setText(text);
    }

    private VBox setUpFilesArea() {
        VBox layout = new VBox();

        Label label = new Label("Files: ");
        FilesText = new TextArea();

        layout.getChildren().add(label);
        layout.getChildren().add(FilesText);
        return layout;
    }

    private void updateFilesArea(String text) {
        FilesText.clear();
        FilesText.setText(text);
    }

    private VBox setUpLockTableArea() {
        VBox layout = new VBox();

        Label label = new Label("LockTable: ");
        LockTableText = new TextArea();

        layout.getChildren().add(label);
        layout.getChildren().add(LockTableText);
        return layout;
    }

    private void updateLockTableArea(String text) {
        LockTableText.clear();
        LockTableText.setText(text);
    }

    private Label setUpProgramStateLabel() {
        labelSelectedProgramState = new Label();
        labelSelectedProgramState.setText("not selected");
        return labelSelectedProgramState;
    }

    private void updateAllSharedResources(TupleItem item) {
        // output area
        String outputText = item.getController().getStateRepository().getOutputCurrentString();
        this.updateOutputArea(outputText);

        // heap area update
        String heapText = item.getController().getStateRepository().getHeapCurrentString();
        this.updateHeapArea(heapText);

        // files area update
        String filesText = item.getController().getStateRepository().getFilesCurrentString();
        this.updateFilesArea(filesText);

        // files locks update
        String locksText = item.getController().getStateRepository().getLocksCurrentString();
        this.updateLockTableArea(locksText);

        // update program states list
        this.updateProgramsStates(item);
    }

    private void setUp(Stage stage) {
        stage.setTitle("Toy Language Interpreter");


        VBox layout = new VBox();

        setUpProgramStateLabel();

        layout.getChildren().add(setUpNumberLabel());

        HBox horizontalBox = new HBox();
        horizontalBox.getChildren().add(setUpProgramsList());
        horizontalBox.getChildren().add(setUpCodeArea());

        setUpProgramStates();
        VBox verticalBox = new VBox();
        verticalBox.getChildren().add(labelSelectedProgramState);
        verticalBox.getChildren().add(programStates);
        verticalBox.getChildren().add(setUpRunAllButton());
        verticalBox.getChildren().add(setUpRunOneStepForAllButton());
        horizontalBox.getChildren().add(verticalBox);

        layout.getChildren().add(horizontalBox);

        layout.getChildren().add(setUpAllStackArea());
        layout.getChildren().add(setUpLockTableArea());

        HBox hBox1 = new HBox();
        hBox1.getChildren().add(setUpAllOutputArea());
        hBox1.getChildren().add(setUpHeapArea());
        layout.getChildren().add(hBox1);

        HBox hBox = new HBox();
        hBox.getChildren().add(setUpSymbolsArea());
        hBox.getChildren().add(setUpFilesArea());
        layout.getChildren().add(hBox);

        Scene scene = new Scene(layout, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // all setup
         this.setUp(primaryStage);

         // this is for error handling
         Thread.setDefaultUncaughtExceptionHandler((t, e) -> Platform.runLater(() -> showErrorDialog(t, e)));
         Thread.currentThread().setUncaughtExceptionHandler(this::showErrorDialog);
    }

    private void showErrorDialog(Thread t, Throwable e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error: " + e.getMessage());

        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
}
