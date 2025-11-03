package ch.tbz.financemanager.service;

import ch.tbz.financemanager.model.Account;
import java.util.ArrayList;
import java.util.List;

/**
 * AccountManager is implemented as a Singleton.
 * Reason: Ensures that there is only one instance managing all accounts.
 * This prevents inconsistencies and makes it easy to access the accounts globally.
 */
public class AccountManager {
    private static AccountManager instance;
    private List<Account> accounts = new ArrayList<>();

    private AccountManager() {}

    public static AccountManager getInstance() {
        if (instance == null) instance = new AccountManager();
        return instance;
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}
