package ATMSystem.Accounts;

import ATMSystem.Exceptions.NegativeAmountException;
import ATMSystem.Exceptions.NotEnoughMoneyException;

public interface IAccount {
    /**
     * Get the account number
     *
     * @return the number
     */
    int getAccountNumber();

    /**
     * Get the current balance of the account
     *
     * @return the balance
     */
    double getBalance();

    /**
     * Deposit specified amount to the account
     *
     * @param amount
     * @throws NegativeAmountException
     */
    void deposit(double amount);

    /**
     * Withdraw specified amount from the account
     *
     * @param amount
     * @throws NegativeAmountException
     * @throws NotEnoughMoneyException
     */
    void withdraw(double amount);

}