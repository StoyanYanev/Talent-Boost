package ATMSystem.Accounts;

import ATMSystem.Exceptions.RestrictionWithdrawException;

public class RestrictedAccount extends StandardAccount {

    private double maxWithdrawSum;

    public RestrictedAccount(int accountNumber, double maxWithdrawSum) {
        this(accountNumber, 0, maxWithdrawSum);
    }

    public RestrictedAccount(int accountNumber, double amount, double maxWithdrawSum) {
        super(accountNumber, amount);
        this.maxWithdrawSum = maxWithdrawSum;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > this.maxWithdrawSum) {
            throw new RestrictionWithdrawException("The amount exceeds the restrictions!");
        }
        super.withdraw(amount);
    }
}