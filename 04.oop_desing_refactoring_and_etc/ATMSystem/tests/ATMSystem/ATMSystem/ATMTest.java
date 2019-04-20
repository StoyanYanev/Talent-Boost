package ATMSystem.ATMSystem;

import ATMSystem.Accounts.IAccount;
import ATMSystem.Exceptions.AccountNotExistException;
import ATMSystem.Exceptions.InvalidPinException;
import ATMSystem.Exceptions.UserNotExistException;
import ATMSystem.User.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ATMTest {
    private static final int MOCKED_USER_ID = 1950;
    private static final int MOCKED_USER_PIN = 4371;
    private static final int MOCKED_USER_NEW_PIN = 5371;
    private static final int MOCKED_ACCOUNT_NUMBER = 21320;

    private static final int INVALID_USER_ID = 3896;
    private static final int INVALID_USER_PIN = 5896;
    private static final int INVALID_ACCOUNT_NUMBER = 703;
    private static final double AMOUNT = 50;

    @Mock
    private User userMock;
    @Mock
    private IAccount accountMock;
    @Mock
    UserManager userManagerMock;
    @Mock
    private IATM atm = new ATM(userManagerMock);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        atm = new ATM(userManagerMock);

        when(userMock.getAccount(MOCKED_ACCOUNT_NUMBER)).thenReturn(accountMock);
        when(userManagerMock.getUser(MOCKED_USER_ID)).thenReturn(userMock);
        when(userMock.validatePin(MOCKED_USER_PIN)).thenReturn(true);

        when(userMock.getAccount(INVALID_ACCOUNT_NUMBER)).thenThrow(AccountNotExistException.class);
        when(userManagerMock.getUser(INVALID_USER_ID)).thenThrow(UserNotExistException.class);
        when(userMock.validatePin(INVALID_USER_PIN)).thenThrow(InvalidPinException.class);
    }

    @Test
    public void depositToAccountWithValidParameters() {
        atm.depositToAccount(MOCKED_USER_ID, MOCKED_USER_PIN, MOCKED_ACCOUNT_NUMBER, AMOUNT);
        verify(accountMock, times(1)).deposit(AMOUNT);
    }

    @Test(expected = AccountNotExistException.class)
    public void depositToNotExistingAccount() {
        atm.depositToAccount(MOCKED_USER_ID, MOCKED_USER_PIN, INVALID_ACCOUNT_NUMBER, AMOUNT);
    }

    @Test(expected = UserNotExistException.class)
    public void depositToAccountWithNoExistingUser() {
        atm.depositToAccount(INVALID_USER_ID, MOCKED_USER_PIN, MOCKED_ACCOUNT_NUMBER, AMOUNT);
    }

    @Test(expected = InvalidPinException.class)
    public void depositToAccountWithInvalidPin() {
        atm.depositToAccount(MOCKED_USER_ID, INVALID_USER_PIN, MOCKED_ACCOUNT_NUMBER, AMOUNT);
    }

    @Test
    public void withdrawFromAccountWithValidParameters() {
        atm.depositToAccount(MOCKED_USER_ID, MOCKED_USER_PIN, MOCKED_ACCOUNT_NUMBER, AMOUNT);
        atm.withdrawFromAccount(MOCKED_USER_ID, MOCKED_USER_PIN, MOCKED_ACCOUNT_NUMBER, AMOUNT);
        verify(accountMock, times(1)).withdraw(AMOUNT);
    }

    @Test(expected = AccountNotExistException.class)
    public void withdrawToNotExistingAccount() {
        atm.withdrawFromAccount(MOCKED_USER_ID, MOCKED_USER_PIN, INVALID_ACCOUNT_NUMBER, AMOUNT);
    }

    @Test(expected = UserNotExistException.class)
    public void withdrawFromAccountWithNoExistingUser() {
        atm.withdrawFromAccount(INVALID_USER_ID, MOCKED_USER_PIN, MOCKED_ACCOUNT_NUMBER, AMOUNT);
    }

    @Test(expected = InvalidPinException.class)
    public void withdrawFromAccountWithInvalidPin() {
        atm.withdrawFromAccount(MOCKED_USER_ID, INVALID_USER_PIN, MOCKED_ACCOUNT_NUMBER, AMOUNT);
    }

    @Test
    public void checkBalanceOfAccountWithValidParameters() {
        atm.checkBalanceOfAccount(MOCKED_USER_ID, MOCKED_USER_PIN, MOCKED_ACCOUNT_NUMBER);
        verify(accountMock, times(1)).getBalance();
    }

    @Test(expected = AccountNotExistException.class)
    public void checkBalanceOfNotExistingAccount() {
        atm.checkBalanceOfAccount(MOCKED_USER_ID, MOCKED_USER_PIN, INVALID_ACCOUNT_NUMBER);
    }

    @Test(expected = UserNotExistException.class)
    public void checkBalanceOfAccountWithNoExistingUser() {
        atm.checkBalanceOfAccount(INVALID_USER_ID, MOCKED_USER_PIN, MOCKED_ACCOUNT_NUMBER);
    }

    @Test(expected = InvalidPinException.class)
    public void checkBalanceOfAccountWithInvalidPin() {
        atm.checkBalanceOfAccount(MOCKED_USER_ID, INVALID_USER_PIN, MOCKED_ACCOUNT_NUMBER);
    }

    @Test
    public void changePinWithValidParameters() {
        atm.changePin(MOCKED_USER_ID, MOCKED_USER_PIN, MOCKED_USER_NEW_PIN);
        verify(userMock, times(1)).changePin(MOCKED_USER_PIN, MOCKED_USER_NEW_PIN);
    }

    @Test(expected = InvalidPinException.class)
    public void changePinWithInvalidParameters() {
        when(userMock.validatePin(INVALID_USER_PIN)).thenReturn(false);
        atm.changePin(MOCKED_USER_ID, INVALID_USER_PIN, MOCKED_USER_NEW_PIN);
    }

    @Test(expected = UserNotExistException.class)
    public void changePinWithNoExistingUser() {
        atm.changePin(INVALID_USER_ID, MOCKED_USER_PIN, MOCKED_USER_NEW_PIN);
    }
}