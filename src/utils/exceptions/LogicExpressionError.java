package utils.exceptions;

public class LogicExpressionError extends RuntimeException {
    public LogicExpressionError() {
    }

    public LogicExpressionError(String message) {
        super(message);
    }
}
