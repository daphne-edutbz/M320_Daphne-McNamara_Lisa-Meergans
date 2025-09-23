package ch.tbz;

public class Milk implements iBuyable{
    private double price;

    public Milk(double price) {
        this.price = price;
    }

    @Override
    public double price() {
        return price;
    }
}
