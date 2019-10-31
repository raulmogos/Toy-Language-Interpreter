package utils.exceptions;

public class DoesAlreadyExist extends Exception {
    public DoesAlreadyExist() {
    }

    public DoesAlreadyExist(String message) {
        super(message);
    }
}
