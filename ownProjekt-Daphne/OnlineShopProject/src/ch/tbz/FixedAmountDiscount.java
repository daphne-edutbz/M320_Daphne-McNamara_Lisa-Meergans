package ch.tbz;

public class FixedAmountDiscount implements DiscountStrategy {
    private double amount;
    public FixedAmountDiscount(double amount) { this.amount = amount; }
    @Override
    public double calculateDiscount(double total) { return amount; }
}

