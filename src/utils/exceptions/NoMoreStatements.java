package utils.exceptions;

public class NoMoreStatements extends RuntimeException {
    public NoMoreStatements() {
    }

    public NoMoreStatements(String message) {
        super(message);
    }
}
