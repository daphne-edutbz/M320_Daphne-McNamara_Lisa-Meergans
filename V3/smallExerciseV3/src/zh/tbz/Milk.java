package zh.tbz;

public class Milk implements iBuyable {
    private String name;
    private double price;

    public Milk(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double price() {
        return price;
    }
}
