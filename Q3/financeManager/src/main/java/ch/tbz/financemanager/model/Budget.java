package ch.tbz.financemanager.model;

import java.util.List;

public class Budget {

    private double limit;

    public Budget(double limit) {
        this.limit = limit;
    }

    public boolean isExceeded(List<Transaction> transactions) {
        double totalExpenses = 0;
        for (Transaction t : transactions) {
            if (t instanceof Expense) {   // only count expenses
                totalExpenses += Math.abs(t.getAmount());
            }
        }
        return totalExpenses > limit;
    }

    public boolean isExceededAfter(Transaction t, List<Transaction> transactions) {
        double totalExpenses = Math.abs(t.getAmount());
        for (Transaction tx : transactions) {
            if (tx instanceof Expense) totalExpenses += Math.abs(tx.getAmount());
        }
        return totalExpenses > limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
