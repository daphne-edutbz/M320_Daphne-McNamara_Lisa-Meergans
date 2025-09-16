package zh.tbz;

public class Banana implements iBuyable {
    private String name;
    private double price;

    public Banana(String name, double price) {
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
