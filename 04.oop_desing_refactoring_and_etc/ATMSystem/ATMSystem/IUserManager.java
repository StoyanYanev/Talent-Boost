package ATMSystem.ATMSystem;

import ATMSystem.Exceptions.AccountNotExistException;
import ATMSystem.Exceptions.UserIsAlreadyExistException;
import ATMSystem.Exceptions.UserNotExistException;
import ATMSystem.User.User;

public interface IUserManager {
    /**
     * Admin operations
     *
     */

    /**
     * @param userId Id of the user
     * @return
     * @throws UserNotExistException if the user not contains in the map
     */
    User getUser(int userId);

    /**
     * Create user of the AtmSystem
     *
     * @param userId Id of the user
     * @param pin    The pin of the user7
     * @throws UserIsAlreadyExistException if the user contains in the map
     */
    void createUser(int userId, int pin);

    /**
     * Create standard account for the specified user
     *
     * @param userId Id of the user
     * @return user's account number for his new standard account
     * @throws UserNotExistException if the user not contains in the map
     */
    int createStandardAccount(int userId);

    /**
     * Create overdraft account for the specified user
     *
     * @param userId         Id of the user
     * @param overdraftLimit The maximum overdraft
     * @return user's account number for his new overdraft account
     * @throws UserNotExistException if the user not contains in the map
     */
    int createOverdraftAccount(int userId, double overdraftLimit);

    /**
     * Create restriction account for the specified user
     *
     * @param userId         Id of the user
     * @param maxWithdrawSum The maximum amount of money which user can withdraw
     * @return user's account number for his new restriction account
     * @throws UserNotExistException    if the user not contains in the map
     * @throws AccountNotExistException if the user doesn't have account with this accountNumber
     */
    int createRestrictionAccount(int userId, double maxWithdrawSum);

    /**
     * Allows the user to share his account with another user
     *
     * @param userId        Id of the user which owns the account
     * @param accountNumber Number of the account to be shared
     * @param userToJoinId  Id of the user who will join the owner of the account
     * @throws UserNotExistException    if the user not contains in the map
     * @throws AccountNotExistException if the user doesn't have account with this accountNumber
     */
    void joinAccounts(int userId, int accountNumber, int userToJoinId);
}