package ATMSystem.User;

import ATMSystem.Accounts.IAccount;
import ATMSystem.Accounts.StandardAccount;
import ATMSystem.Exceptions.AccountIsAlreadyExistException;
import ATMSystem.Exceptions.AccountNotExistException;
import ATMSystem.Exceptions.SamePinAsOldException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private static final int USER_ID = 9631;
    private static final int USER_PIN = 2563;
    private static final int NEW_PIN = 6666;
    private static final int ACCOUNT_NUMBER = 21320;
    private static final int INVALID_ACCOUNT_NUMBER = 57827;

    private User user;

    @Before
    public void setUp() {
        user = new User(USER_ID, USER_PIN);
        IAccount account = new StandardAccount(ACCOUNT_NUMBER);
        user.addAccount(account);
    }

    @Test(expected = AccountIsAlreadyExistException.class)
    public void addExistingAccount() {
        IAccount account = new StandardAccount(ACCOUNT_NUMBER);
        user.addAccount(account);
    }

    @Test(expected = AccountNotExistException.class)
    public void getNotExistingAccount() {
        assertEquals(INVALID_ACCOUNT_NUMBER, user.getAccount(INVALID_ACCOUNT_NUMBER).getAccountNumber());
    }

    @Test
    public void changeOldPin() {
        user.changePin(USER_PIN, NEW_PIN);
        assertEquals(NEW_PIN, user.getPin());
    }

    @Test(expected = SamePinAsOldException.class)
    public void changeSamePinAsOldPin() {
        user.changePin(USER_PIN, USER_PIN);
    }
}