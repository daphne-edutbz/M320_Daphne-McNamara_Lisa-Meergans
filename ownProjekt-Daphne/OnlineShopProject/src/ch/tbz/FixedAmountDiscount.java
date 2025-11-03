package ch.tbz;

/**
 * Discount strategy that subtracts a fixed amount from total.
 * Example of Strategy pattern.
 */
public class FixedAmountDiscount implements DiscountStrategy {
    private double amount;

    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateDiscount(double total) {
        return amount;
    }
}
