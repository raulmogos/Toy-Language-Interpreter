package utils.exceptions;

public class NoMoreStatementsError extends RuntimeException {
    public NoMoreStatementsError() {
    }

    public NoMoreStatementsError(String message) {
        super(message);
    }
}
