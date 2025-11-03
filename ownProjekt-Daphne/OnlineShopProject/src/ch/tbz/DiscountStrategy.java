package ch.tbz;

/**
 * Strategy pattern interface for applying discounts.
 * Different implementations calculate discounts differently.
 */
public interface DiscountStrategy {
    double calculateDiscount(double total);
}
