package utils.exceptions;

public class DoesNotExistError extends RuntimeException {
    public DoesNotExistError() {
    }

    public DoesNotExistError(String message) {
        super(message);
    }
}
