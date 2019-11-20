package utils.exceptions;

public class DoesAlreadyExistError extends RuntimeException {
    public DoesAlreadyExistError() {
    }

    public DoesAlreadyExistError(String message) {
        super(message);
    }
}
