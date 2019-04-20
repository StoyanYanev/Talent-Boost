package ATMSystem.User;

import ATMSystem.Accounts.IAccount;
import ATMSystem.Exceptions.AccountIsAlreadyExistException;
import ATMSystem.Exceptions.AccountNotExistException;
import ATMSystem.Exceptions.InvalidPinException;
import ATMSystem.Exceptions.SamePinAsOldException;

public interface IUser {
    /**
     * @return the user id
     */
    int getUserId();

    /**
     * @return the pin
     */
    int getPin();

    /**
     * Add account to user account list
     *
     * @param account the account to add in account list
     * @throws AccountIsAlreadyExistException
     */
    void addAccount(IAccount account);

    /**
     * Get User account by account number
     *
     * @param accountNumber
     * @return
     * @throws AccountNotExistException
     */
    IAccount getAccount(int accountNumber);

    /**
     * Validate pin of the user
     *
     * @param pin The pin to validate
     * @throws InvalidPinException
     */
    boolean validatePin(int pin);

    /**
     * Change pin of the user
     *
     * @param oldPin Old pin
     * @param newPin New pin to be set
     * @throws InvalidPinException
     * @throws SamePinAsOldException
     */
    void changePin(int oldPin, int newPin);
}