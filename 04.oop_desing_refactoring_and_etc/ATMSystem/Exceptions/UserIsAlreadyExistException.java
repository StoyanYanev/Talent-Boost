package ATMSystem.Exceptions;

public class UserIsAlreadyExistException extends RuntimeException {
    public UserIsAlreadyExistException(String message) {
        super(message);
    }
}