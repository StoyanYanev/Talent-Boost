package ATMSystem.ATMSystem;

import ATMSystem.Accounts.IAccount;
import ATMSystem.Accounts.OverdraftAccount;
import ATMSystem.Accounts.RestrictedAccount;
import ATMSystem.Accounts.StandardAccount;
import ATMSystem.Exceptions.AccountNotExistException;
import ATMSystem.Exceptions.UserIsAlreadyExistException;
import ATMSystem.Exceptions.UserNotExistException;
import ATMSystem.User.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager implements IUserManager {
    /**
     * The key of the map is user id
     * The vale of the map is User
     */
    private Map<Integer, User> users;
    private int accountNumberGenerator;

    /**
     * @param userId Id of the user
     * @return true if the user contains in the map
     */

    private boolean checkUserExist(int userId) {
        return this.users.containsKey(userId);
    }

    /**
     * Generator of the new id for accounts
     *
     * @return account id of the user
     */

    private int nextAccountId() {
        return this.accountNumberGenerator++;
    }

    /**
     * @param userId        Id of the user
     * @param accountNumber Number of the user account
     * @return the account of the user
     * @throws UserNotExistException    if the user not contains in the map
     * @throws AccountNotExistException if the user doesn't have account with this accountNumber
     */

    private IAccount getAccount(int userId, int accountNumber) {
        User currentUser = this.getUser(userId);
        IAccount currentAccount = currentUser.getAccount(accountNumber);
        return currentAccount;
    }

    /**
     * If the user already exists one more account is added to his accounts
     *
     * @param userId     Id of the user
     * @param newAccount Adding new account of the user
     * @throws UserNotExistException if the user not contains in the map
     */

    private void createAccountsHelper(int userId, IAccount newAccount) {
        User currentUser = this.getUser(userId);
        currentUser.addAccount(newAccount);
    }

    public UserManager() {
        this.users = new HashMap<>();
        this.accountNumberGenerator = 0;
    }

    @Override
    public User getUser(int userId) {
        if (!this.checkUserExist(userId)) {
            throw new UserNotExistException("The user doesn't exist!");
        }
        return this.users.get(userId);
    }

    @Override
    public void createUser(int userId, int pin) {
        if (this.checkUserExist(userId)) {
            throw new UserIsAlreadyExistException("The user already exists!");
        }
        User user = new User(userId, pin);
        this.users.put(userId, user);
    }

    /**
     * @throws UserNotExistException if the user not contains in the map
     */
    @Override
    public int createStandardAccount(int userId) {
        int accountNumber = this.nextAccountId();
        IAccount newAccount = new StandardAccount(accountNumber);
        this.createAccountsHelper(userId, newAccount);
        return accountNumber;
    }

    /**
     * @throws UserNotExistException if the user not contains in the map
     */

    @Override
    public int createOverdraftAccount(int userId, double overdraftLimit) {
        int accountNumber = this.nextAccountId();
        IAccount newAccount = new OverdraftAccount(accountNumber, overdraftLimit);
        this.createAccountsHelper(userId, newAccount);
        return accountNumber;
    }

    /**
     * @throws UserNotExistException if the user not contains in the map
     */
    @Override
    public int createRestrictionAccount(int userId, double maxWithdrawSum) {
        int accountNumber = this.nextAccountId();
        IAccount newAccount = new RestrictedAccount(accountNumber, maxWithdrawSum);
        this.createAccountsHelper(userId, newAccount);
        return accountNumber;
    }

    /**
     * @throws UserNotExistException    if the user not contains in the map
     * @throws AccountNotExistException if the user doesn't have account with this accountNumber
     */
    @Override
    public void joinAccounts(int userId, int accountNumber, int userToJoinId) {
        IAccount account = this.getAccount(userId, accountNumber);
        User userToJoin = this.getUser(userToJoinId);
        userToJoin.addAccount(account);
    }
}