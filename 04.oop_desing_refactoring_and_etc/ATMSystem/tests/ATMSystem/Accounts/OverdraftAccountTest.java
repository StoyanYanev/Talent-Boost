package ATMSystem.Accounts;

import ATMSystem.Exceptions.OverdraftLimitException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverdraftAccountTest {
    private static final int ACCOUNT_NUMBER = 8523;
    private static final double OVERDRAFT_LIMIT = -50;
    private static final double BIGGER_SUM_THAN_OVERDRAFT_LIMIT = 200;
    private static final double DEPOSIT_SUM = 50;
    private static final double WITHDRAW_SUM = 50;

    private OverdraftAccount account;

    @Before
    public void setUp() {
        account = new OverdraftAccount(ACCOUNT_NUMBER, OVERDRAFT_LIMIT);
    }

    @Test
    public void withdrawPositiveAmount() {
        account.deposit(DEPOSIT_SUM);
        account.withdraw(WITHDRAW_SUM);
        assertEquals(DEPOSIT_SUM - WITHDRAW_SUM, account.getBalance(), 0.0);
    }

    @Test(expected = OverdraftLimitException.class)
    public void withdrawAmountBiggerThanTheOverdraftLimit() {
        account.deposit(DEPOSIT_SUM);
        account.withdraw(BIGGER_SUM_THAN_OVERDRAFT_LIMIT);
    }
}