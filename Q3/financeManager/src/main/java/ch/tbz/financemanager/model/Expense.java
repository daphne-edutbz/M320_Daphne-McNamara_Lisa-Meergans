package ch.tbz.financemanager.model;

import java.time.LocalDate;

public class Expense extends Transaction {

    private String category;
    private boolean essential;

    public Expense(double amount, LocalDate date, String description, String category, boolean essential) {
        super(-Math.abs(amount), date, description);
        this.category = category;
        this.essential = essential;
    }

    public boolean isEssential() {
        return essential;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAboveLimit(double limit) {
        return Math.abs(amount) > limit;
    }

    @Override
    public String getType() {
        return "Expense";
    }
}
