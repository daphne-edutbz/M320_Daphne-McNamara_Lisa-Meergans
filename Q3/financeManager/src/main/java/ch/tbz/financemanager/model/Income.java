package ch.tbz.financemanager.model;

import java.time.LocalDate;

/**
 * Represents an income transaction (money inflow).
 */
public class Income extends Transaction {

    private final boolean recurring;

    public Income(double amount, LocalDate date, String description, boolean recurring) {
        super(amount, date, description);
        this.recurring = recurring;
    }

    public boolean isRecurring() {
        return recurring;
    }

    @Override
    public double getNetAmount() {
        return amount; // income increases the balance
    }

    @Override
    public String getType() {
        return "Income";
    }

    @Override
    public String toString() {
        return super.toString() + (recurring ? " (recurring)" : "");
    }
}
