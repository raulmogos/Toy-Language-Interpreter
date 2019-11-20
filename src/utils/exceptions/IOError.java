package utils.exceptions;

public class IOError extends RuntimeException {
    public IOError() {
    }

    public IOError(String message) {
        super(message);
    }
}
