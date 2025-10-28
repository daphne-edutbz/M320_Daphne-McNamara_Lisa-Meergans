package ch.tbz.financemanager.model;

import java.time.LocalDate;

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

    public abstract String getType();

    public String getDescription() {
        return description;
    }
}
