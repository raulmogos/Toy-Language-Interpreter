package utils.exceptions;

public class DoesAlreadyExist extends RuntimeException {
    public DoesAlreadyExist() {
    }

    public DoesAlreadyExist(String message) {
        super(message);
    }
}
