package ch.tbz.financemanager.model;

import java.util.ArrayList;
import java.util.List;
import ch.tbz.financemanager.exception.*;

public class Account {

    private String accountName;
    private double balance;
    private List<Transaction> transactions;
    private Budget budget;
    private int pin;

    public Account(String name, double balance, int pin) {
        this.accountName = name;
        this.balance = balance;
        this.pin = pin;
        this.transactions = new ArrayList<>();
    }

    /**
     * Adds a transaction to this account.
     * @param t Transaction to add
     * @throws InvalidTransactionException if amount is 0 or description is missing
     * @throws BudgetExceededException if adding transaction exceeds budget
     */

    public void addTransaction(Transaction t) {
        if (t.getAmount() == 0) {
            throw new InvalidTransactionException("Transaction amount cannot be zero");
        }
        if (t.getDescription() == null || t.getDescription().isEmpty()) {
            throw new InvalidTransactionException("Transaction must have a description");
        }
        if (budget != null && budget.isExceededAfter(t, transactions)) {
            throw new BudgetExceededException("Adding this transaction exceeds your budget!");
        }
        transactions.add(t);
        balance += t.getAmount();
    }


    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean checkBudget() {
        return budget == null || !budget.isExceeded(transactions);
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
