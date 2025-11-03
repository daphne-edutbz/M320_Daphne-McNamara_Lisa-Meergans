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

    /**
     * Calculates the remaining budget by subtracting total expenses from the limit.
     */
    public double remainingBudget(List<Transaction> transactions) {
        double totalExpenses = 0;
        for (Transaction t : transactions) {
            if (t instanceof Expense) {
                totalExpenses += Math.abs(t.getAmount());
            }
        }
        return limit - totalExpenses;
    }

    /**
     * Prints the current budget status and remaining balance.
     */
    public void printBudgetStatus(List<Transaction> transactions) {
        double remaining = remainingBudget(transactions);
        System.out.println("Budget limit: " + limit + " CHF | Remaining: " + remaining + " CHF");
        if (remaining < 0) {
            System.out.println("You have exceeded your budget!");
        } else if (remaining < limit * 0.1) {
            System.out.println("Warning: You are close to exceeding your budget!");
        } else {
            System.out.println("Budget is within safe range.");
        }
    }
}
