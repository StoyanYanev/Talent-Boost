package ATMSystem.Exceptions;

public class SamePinAsOldException extends RuntimeException {
    public SamePinAsOldException(String message) {
        super(message);
    }
}