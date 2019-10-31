package utils.exceptions;

public class DoesNotExistError extends Exception {
    public DoesNotExistError() {
    }

    public DoesNotExistError(String message) {
        super(message);
    }
}
