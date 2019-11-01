package utils.exceptions;

public class DivisionByZeroError extends Exception {
    public DivisionByZeroError() {
    }

    public DivisionByZeroError(String message) {
        super(message);
    }
}
