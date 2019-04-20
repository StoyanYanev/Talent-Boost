package ATMSystem.ATMSystem;

import ATMSystem.Accounts.IAccount;
import ATMSystem.Exceptions.InvalidPinException;
import ATMSystem.Exceptions.SamePinAsOldException;
import ATMSystem.Exceptions.UserNotExistException;
import ATMSystem.Exceptions.AccountNotExistException;
import ATMSystem.User.User;

public class ATM implements IATM {

    private UserManager userManager;

    /**
     * @param userId        Id of the user
     * @param pin           The Pin of the user
     * @param accountNumber Number of the user account
     * @return the account of the user
     * @throws UserNotExistException    if the user not contains in the userManager
     * @throws InvalidPinException      if the pint is incorrect
     * @throws AccountNotExistException if the user doesn't have account with this accountNumber
     */

    private IAccount helperForAccountsOperations(int userId, int pin, int accountNumber) {
        User user = this.userManager.getUser(userId);
        user.validatePin(pin);
        IAccount account = user.getAccount(accountNumber);
        return account;
    }


    /**
     * @param userId Id of the user
     * @return the user
     * @throws UserNotExistException if the user not contains in the userManager
     */
    User getUser(int userId) {
        return this.userManager.getUser(userId);
    }

    public ATM(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * @throws UserNotExistException    if the user not contains in the userManager
     * @throws InvalidPinException      if the pint is incorrect
     * @throws AccountNotExistException if the user doesn't have account with this accountNumber
     */
    @Override
    public void depositToAccount(int userId, int pin, int accountNumber, double amount) {
        IAccount currentAccount = this.helperForAccountsOperations(userId, pin, accountNumber);
        currentAccount.deposit(amount);
    }

    /**
     * @throws UserNotExistException    if the user not contains in the userManager
     * @throws InvalidPinException      if the pint is incorrect
     * @throws AccountNotExistException if the user doesn't have account with this accountNumber
     */
    @Override
    public void withdrawFromAccount(int userId, int pin, int accountNumber, double amount) {
        IAccount currentAccount = this.helperForAccountsOperations(userId, pin, accountNumber);
        currentAccount.withdraw(amount);
    }

    /**
     * @throws UserNotExistException    if the user not contains in the userManager
     * @throws InvalidPinException      if the pint is incorrect
     * @throws AccountNotExistException if the user doesn't have account with this accountNumber
     */
    @Override
    public double checkBalanceOfAccount(int userId, int pin, int accountNumber) {
        IAccount currentAccount = this.helperForAccountsOperations(userId, pin, accountNumber);
        return currentAccount.getBalance();
    }

    /**
     * @throws UserNotExistException if the user not contains in the userManager
     * @throws InvalidPinException   if the pin is incorrect
     * @throws SamePinAsOldException if the new pin is the same as old pin
     */

    @Override
    public void changePin(int userId, int oldPin, int newPin) {
        User user = this.userManager.getUser(userId);
        user.changePin(oldPin, newPin);
    }
}