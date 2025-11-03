package ch.tbz;

public class GiftWrapDecorator extends ProductDecorator{

    public GiftWrapDecorator(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " +Gift Wrapping";
    }

    @Override
    public double getPrice() {
        return product.getPrice() + 5.0; //wrapping cost
    }
}
