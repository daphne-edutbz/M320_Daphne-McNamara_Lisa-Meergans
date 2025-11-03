package ch.tbz.financemanager.model;

import java.time.LocalDate;

/**
 * Base class for all transactions (abstract).
 * Reason for inheritance: Income and Expense share common attributes
 * like amount, date, description. Polymorphism allows treating
 * all transactions uniformly.
 */

public abstract class Transaction {

    protected double amount;
    protected LocalDate date;
    protected String description;

    public Transaction(double amount, LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    /** Returns whether this transaction is recurring (default = false). */
    public boolean isRecurring() {
        return false;
    }

    /** Returns the net effect on account balance (income positive, expense negative). */
    public abstract double getNetAmount();

    /** Returns a textual type description (Income / Expense). */
    public abstract String getType();

    @Override
    public String toString() {
        return String.format("[%s] %.2f CHF on %s - %s", getType(), amount, date, description);
    }
}
