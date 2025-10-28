package ch.tbz.financemanager.model;

import java.util.List;

public class Budget {

    private double limit;

    public Budget(double limit) {
        this.limit = limit;
    }

    public boolean isExceeded(List<Transaction> transactions) {
        double total = 0;
        for (Transaction t : transactions) {
            total += t.getAmount();
        }
        return total > limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
