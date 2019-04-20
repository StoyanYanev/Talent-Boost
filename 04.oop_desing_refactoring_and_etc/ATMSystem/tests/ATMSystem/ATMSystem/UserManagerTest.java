package ATMSystem.ATMSystem;

import ATMSystem.Exceptions.AccountNotExistException;
import ATMSystem.Exceptions.UserIsAlreadyExistException;
import ATMSystem.Exceptions.UserNotExistException;
import ATMSystem.User.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserManagerTest {
    private static final int USER_ID = 1950;
    private static final int USER_PIN = 4371;
    private static final int JOIN_USER_ID = 7896;
    private static final int JOIN_USER_PIN = 1256;
    private static final int ACCOUNT_NUMBER = 15;

    private static final int INVALID_USER_ID = 3896;
    private static final int INVALID_ACCOUNT_NUMBER = 703;

    private IUserManager userManager;

    @Before
    public void setUp() {
        userManager = new UserManager();
        userManager.createUser(USER_ID, USER_PIN);
    }

    @Test(expected = UserNotExistException.class)
    public void getNoExistingUser() {
        userManager.getUser(INVALID_USER_ID);
    }

    @Test(expected = UserIsAlreadyExistException.class)
    public void createExistingUser() {
        int newPin = 8371;
        userManager.createUser(USER_ID, newPin);
    }

    @Test
    public void createStandardAccountWithValidParameters() {
        User user = userManager.getUser(USER_ID);
        int accountNumber = userManager.createStandardAccount(USER_ID);

        assertNotNull(user.getAccount(accountNumber));
    }

    @Test(expected = UserNotExistException.class)
    public void createStandardAccountWithNoExistingUser() {
        userManager.createStandardAccount(INVALID_USER_ID);
    }

    @Test
    public void joinAccountWithValidParameters() {
        int accountNumber = userManager.createStandardAccount(USER_ID);
        userManager.createUser(JOIN_USER_ID, JOIN_USER_PIN);
        userManager.joinAccounts(USER_ID, accountNumber, JOIN_USER_ID);
        User userToJoin = userManager.getUser(JOIN_USER_ID);

        assertNotNull(userToJoin.getAccount(accountNumber));
    }

    @Test(expected = UserNotExistException.class)
    public void joinAccountWithNotExistingUser() {
        userManager.joinAccounts(INVALID_USER_ID, ACCOUNT_NUMBER, JOIN_USER_ID);
    }

    @Test(expected = AccountNotExistException.class)
    public void joinAccountWithNotExistingAccount() {
        userManager.joinAccounts(USER_ID, INVALID_ACCOUNT_NUMBER, JOIN_USER_ID);
    }
}