package zh.tbz;

public class DiscountPolicy implements PricingPolicy{
    private double dailyRate;
    public double discountRate;

    public DiscountPolicy(double dailyRate, double discountRate){
        this.dailyRate = dailyRate;
        this.discountRate = discountRate;

    }

    @Override
    public double calculatePrice(int days) {
        double totalPrice = dailyRate * days;
        if (days >= 5) totalPrice *= (1 - discountRate);
        return totalPrice;
    }
}
