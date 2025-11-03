package ch.tbz;

//Polymorphism
public class NoDiscount implements DiscountStrategy {
    public double calculateDiscount(double total) {
        return 0;
    }
}
