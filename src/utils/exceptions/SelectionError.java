package utils.exceptions;

public class SelectionError extends RuntimeException {
    public SelectionError() {
    }

    public SelectionError(String message) {
        super(message);
    }
}
