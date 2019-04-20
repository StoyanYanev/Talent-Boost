package ATMSystem.Exceptions;

public class RestrictionWithdrawException extends RuntimeException {
    public RestrictionWithdrawException(String message) {
        super(message);
    }
}