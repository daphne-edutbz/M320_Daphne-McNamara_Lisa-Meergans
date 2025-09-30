package zh.tbz;

public class FlatRatePolicy implements PricingPolicy{
    private double dailyRate;

    public FlatRatePolicy(double dailyRate) {
        this.dailyRate = dailyRate;
    }


    @Override
    public double calculatePrice(int days) {
        return dailyRate * days;
    }
}
