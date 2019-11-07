package utils.exceptions;

public class DivisionByZeroError extends RuntimeException {
    public DivisionByZeroError() {
    }

    public DivisionByZeroError(String message) {
        super(message);
    }
}
