package ATMSystem.ATMSystem;

import ATMSystem.Exceptions.InvalidPinException;
import ATMSystem.Exceptions.SamePinAsOldException;
import ATMSystem.Exceptions.UserNotExistException;

public interface IATM {
    /**
     * Deposit to user account
     *
     * @param userId        Id of the user
     * @param pin           The pin of the user
     * @param accountNumber Number of the user account
     * @param amount        Amount to be deposit to the user account
     */
    void depositToAccount(int userId, int pin, int accountNumber, double amount);

    /**
     * Withdraw from user account
     *
     * @param userId        Id of the user
     * @param pin           The pin of the user
     * @param accountNumber Number of the user account
     * @param amount        Amount to be withdraw from the user account
     */
    void withdrawFromAccount(int userId, int pin, int accountNumber, double amount);

    /**
     * Check the balance of a user account
     *
     * @param userId        Id of the user
     * @param pin           The pin of the user
     * @param accountNumber Number of the user account
     * @return Current amount of the user account
     */
    double checkBalanceOfAccount(int userId, int pin, int accountNumber);

    /**
     * Change pin of a user
     *
     * @param userId Id of the user
     * @param oldPin Old user pin
     * @param newPin New pin to be set
     * @throws UserNotExistException if the user not contains in the userManager
     * @throws InvalidPinException   if the pin is incorrect
     * @throws SamePinAsOldException if the new pin is the same as old pin
     */
    void changePin(int userId, int oldPin, int newPin);
}