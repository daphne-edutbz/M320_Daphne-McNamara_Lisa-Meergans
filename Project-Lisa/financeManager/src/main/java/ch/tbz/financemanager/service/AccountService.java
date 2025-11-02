package ch.tbz.financemanager.service;

import ch.tbz.financemanager.model.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides higher-level operations on Accounts and Transactions.
 * Used by controllers or reports to calculate summaries and filters.
 */
public class AccountService {

    public double calculateTotalIncome(Account account) {
        return account.getTransactions().stream()
                .filter(t -> t instanceof Income)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double calculateTotalExpenses(Account account) {
        return account.getTransactions().stream()
                .filter(t -> t instanceof Expense)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public List<Expense> getEssentialExpenses(Account account) {
        return account.getTransactions().stream()
                .filter(t -> t instanceof Expense e && e.isEssential())
                .map(t -> (Expense) t)
                .collect(Collectors.toList());
    }

    public List<Income> getRecurringIncomes(Account account) {
        return account.getTransactions().stream()
                .filter(t -> t instanceof Income i && i.isRecurring())
                .map(t -> (Income) t)
                .collect(Collectors.toList());
    }

    public double calculateNetBalance(Account account) {
        return calculateTotalIncome(account) - calculateTotalExpenses(account);
    }
}
