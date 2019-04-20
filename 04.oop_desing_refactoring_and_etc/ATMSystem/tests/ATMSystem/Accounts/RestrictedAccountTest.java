package ATMSystem.Accounts;

import ATMSystem.Exceptions.RestrictionWithdrawException;
import org.junit.Before;
import org.junit.Test;

public class RestrictedAccountTest {
    private static final int ACCOUNT_NUMBER = 71826;
    private static final double MAX_WITHDRAW_SUM = 400;
    private static final double DEPOSIT_SUM = 500;
    private static final double BIGGER_THAN_MAX_WITHDRAW_SUM = 445;

    private RestrictedAccount account;

    @Before
    public void setUp() {
        account = new RestrictedAccount(ACCOUNT_NUMBER, MAX_WITHDRAW_SUM);
    }

    @Test(expected = RestrictionWithdrawException.class)
    public void withdrawAmountBiggerThanTheMaxWithdrawSum() {
        account.deposit(DEPOSIT_SUM);
        account.withdraw(BIGGER_THAN_MAX_WITHDRAW_SUM);
    }
}