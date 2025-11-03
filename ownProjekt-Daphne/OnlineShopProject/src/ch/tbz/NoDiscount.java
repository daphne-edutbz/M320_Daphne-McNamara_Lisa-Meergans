package ch.tbz;

/**
 * Discount strategy that applies no discount.
 * Demonstrates polymorphism: same interface, different behavior.
 */
public class NoDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double total) {
        return 0;
    }
}
