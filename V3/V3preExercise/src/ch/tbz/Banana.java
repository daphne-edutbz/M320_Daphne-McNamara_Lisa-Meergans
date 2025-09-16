package ch.tbz;

public class Banana implements iBuyable{
    private double price;

    public Banana(double price) {
        this.price = price;
    }

    @Override
    public double price() {
        return price;
    }
}
