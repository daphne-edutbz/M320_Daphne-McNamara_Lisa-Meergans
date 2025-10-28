package ch.tbz.financemanager.model;

import java.time.LocalDate;

public class Income extends Transaction {

    private boolean recurring;

    public Income(double amount, LocalDate date, String description, boolean recurring) {
        super(amount, date, description);
        this.recurring = recurring;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public double getNetAmount() {
        return amount;
    }

    public String categorize() {
        return recurring ? "Recurring Income" : "One-time Income";
    }

    @Override
    public String getType() {
        return "Income";
    }
}
