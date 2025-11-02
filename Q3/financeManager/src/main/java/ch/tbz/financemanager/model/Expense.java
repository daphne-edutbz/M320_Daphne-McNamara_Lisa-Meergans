package ch.tbz.financemanager.model;

import java.time.LocalDate;

/**
 * Represents an expense transaction (money outflow).
 */
public class Expense extends Transaction {

    private final String category;
    private final boolean essential;

    public Expense(double amount, LocalDate date, String description, String category, boolean essential) {
        super(amount, date, description);
        this.category = category;
        this.essential = essential;
    }

    public boolean isEssential() {
        return essential;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public double getNetAmount() {
        return -amount; // expenses reduce the balance
    }

    @Override
    public String getType() {
        return "Expense";
    }

    /** Checks if this expense exceeds a given limit. */
    public boolean isAboveLimit(double limit) {
        return Math.abs(amount) > limit;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Category: %s | Essential: %b", category, essential);
    }
}
