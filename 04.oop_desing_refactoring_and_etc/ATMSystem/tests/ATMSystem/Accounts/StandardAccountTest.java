package ATMSystem.Accounts;

import ATMSystem.Exceptions.NegativeAmountException;
import ATMSystem.Exceptions.NotEnoughMoneyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StandardAccountTest {
    private static final int ACCOUNT_NUMBER = 1256;
    private static final double DEPOSIT_SUM = 200;
    private static final double WITHDRAW_SUM = 20;
    private static final double DEPOSIT_NEGATIVE_SUM = -200;
    private static final double BIGGER_SUM = 824;

    private StandardAccount account;

    @Before
    public void setUp() {
        account = new StandardAccount(ACCOUNT_NUMBER);
    }

    @Test
    public void depositPositiveAmount() {
        account.deposit(DEPOSIT_SUM);
        assertEquals(DEPOSIT_SUM, account.getBalance(), 0.0);
    }

    @Test(expected = NegativeAmountException.class)
    public void depositNegativeAmount() {
        account.deposit(DEPOSIT_NEGATIVE_SUM);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void withdrawAmountBiggerThanTheCurrent() {
        account.deposit(DEPOSIT_SUM);
        account.withdraw(BIGGER_SUM);
    }

    @Test
    public void withdrawPositiveAmount() {
        account.deposit(DEPOSIT_SUM);
        account.withdraw(WITHDRAW_SUM);
        assertEquals(DEPOSIT_SUM - WITHDRAW_SUM, account.getBalance(), 0.0);
    }
}