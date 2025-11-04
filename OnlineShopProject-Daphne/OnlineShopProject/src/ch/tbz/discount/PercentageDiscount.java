package ch.tbz.discount;

/**
 * calculates a discount as a percentage of the total price.
 *
 * <p>Demonstrates the Strategy pattern and polymorphism: different discount
 * strategies can be applied interchangeably.</p>
 */
public class PercentageDiscount implements DiscountStrategy {
    private double percent;

    /**
     * Creates a new PercentageDiscount with the given percentage.
     *
     * @param percent the discount percentage
     */
    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    /**
     * Calculates the discount for a given total price.
     *
     * @param total the total price before discount
     * @return the amount of discount to subtract from the total
     */
    public double calculateDiscount(double total) {
        return total * (percent / 100);
    }
}
