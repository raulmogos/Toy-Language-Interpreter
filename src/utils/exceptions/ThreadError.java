package utils.exceptions;

public class ThreadError extends RuntimeException {
    public ThreadError() {
    }

    public ThreadError(String message) {
        super(message);
    }
}
