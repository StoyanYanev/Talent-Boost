package ATMSystem.Accounts;

import ATMSystem.Exceptions.NegativeAmountException;
import ATMSystem.Exceptions.NotEnoughMoneyException;

public class StandardAccount implements IAccount {

    private int accountNumber;
    protected double amount;

    protected void updateAmount(double amount) {
        this.amount = amount;
    }

    protected void validateAmount(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("The amount can not be negative!");
        }
    }

    public StandardAccount(int accountNumber) {
        this(accountNumber, 0);
    }

    public StandardAccount(int accountNumber, double amount) {
        this.validateAmount(amount);
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public double getBalance() {
        return this.amount;
    }

    @Override
    public void deposit(double amount) {
        this.validateAmount(amount);
        this.amount += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.validateAmount(amount);
        if (amount > this.getBalance()) {
            throw new NotEnoughMoneyException("Not enough money!");
        }
        this.amount -= amount;
    }
}