package ATMSystem.Exceptions;

public class OverdraftLimitException extends RuntimeException {
    public OverdraftLimitException(String message) {
        super(message);
    }
}