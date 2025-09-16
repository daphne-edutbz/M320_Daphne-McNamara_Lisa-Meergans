package zh.tbz;

public class Milk implements iBuyable {
    private String name;
    private double price;

    public Milk(double price) {
        this.price = price;
    }

    @Override
    public String name() {
        return "Milk";
    }

    @Override
    public double price() {
        return price;
    }
}
