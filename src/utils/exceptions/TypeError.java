package utils.exceptions;

public class TypeError extends RuntimeException {
    public TypeError() {
    }

    public TypeError(String message) {
        super(message);
    }
}
