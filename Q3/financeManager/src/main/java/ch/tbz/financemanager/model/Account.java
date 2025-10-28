package ch.tbz.financemanager.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountName;
    private double balance;
    private List<Transaction> transactions;
    private Budget budget;

    public Account(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
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
}
