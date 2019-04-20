package ATMSystem.User;

import ATMSystem.Accounts.IAccount;
import ATMSystem.Exceptions.AccountIsAlreadyExistException;
import ATMSystem.Exceptions.AccountNotExistException;
import ATMSystem.Exceptions.InvalidPinException;
import ATMSystem.Exceptions.SamePinAsOldException;

import java.util.HashMap;
import java.util.Map;

public class User implements IUser {
    private int id;
    private int pin;
    /**
     * The key of the map is account number
     * The vale of the map is AccountInterface
     */
    private Map<Integer, IAccount> accounts;

    public User(int id, int pin) {
        this.id = id;
        this.pin = pin;
        this.accounts = new HashMap<>();
    }

    @Override
    public int getUserId() {
        return this.id;
    }

    @Override
    public int getPin() {
        return this.pin;
    }

    @Override
    public void addAccount(IAccount account) {
        if (this.accounts.containsKey(account.getAccountNumber())) {
            throw new AccountIsAlreadyExistException("The account already exists!");
        }
        this.accounts.put(account.getAccountNumber(), account);
    }

    @Override
    public IAccount getAccount(int accountNumber) {
        IAccount account = this.accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotExistException("Account not exist!");
        }
        return account;
    }

    @Override
    public boolean validatePin(int pin) {
        if (this.getPin() != pin) {
            throw new InvalidPinException("Invalid pin!");
        }
        return true;
    }

    @Override
    public void changePin(int oldPin, int newPin) {
        if (this.getPin() != oldPin) {
            throw new InvalidPinException("Invalid old pin!");
        }
        if (oldPin == newPin) {
            throw new SamePinAsOldException("The pin is same as old!");
        }
        this.pin = newPin;
    }
}