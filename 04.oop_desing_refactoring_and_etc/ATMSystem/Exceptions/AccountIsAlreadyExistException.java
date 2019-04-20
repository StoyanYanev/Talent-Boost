package ATMSystem.Exceptions;

public class AccountIsAlreadyExistException extends RuntimeException{
    public AccountIsAlreadyExistException(String message){
        super(message);
    }
}