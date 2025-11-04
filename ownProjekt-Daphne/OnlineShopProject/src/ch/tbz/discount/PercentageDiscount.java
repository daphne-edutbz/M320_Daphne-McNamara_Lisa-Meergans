package ch.tbz.discount;

//Polymorphism
public class PercentageDiscount implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double calculateDiscount(double total) {
        return total * (percent / 100);
    }
}
