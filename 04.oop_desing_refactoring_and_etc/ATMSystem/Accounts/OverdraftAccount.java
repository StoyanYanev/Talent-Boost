package ATMSystem.Accounts;

import ATMSystem.Exceptions.OverdraftLimitException;

public class OverdraftAccount extends StandardAccount {
    private double overdraftLimit;

    public OverdraftAccount(int accountNumber, double overdraftLimit) {
        this(accountNumber, 0, overdraftLimit);
    }

    public OverdraftAccount(int accountNumber, double amount, double overdraftLimit) {
        super(accountNumber, amount);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        this.validateAmount(amount);
        double newSum = this.getBalance() - amount;
        if (Math.abs(newSum) > Math.abs(this.overdraftLimit)) {
            throw new OverdraftLimitException("The limit was overdraft!");
        }
        this.updateAmount(newSum);
    }
}