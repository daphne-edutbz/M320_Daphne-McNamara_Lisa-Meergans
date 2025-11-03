package ch.tbz;

/**
 * Decorator that adds gift wrapping to a product
 * Demonstrates Decorator pattern
 */
public class GiftWrapDecorator extends ProductDecorator {
    private static final double WRAP_COST = 5.0;

    public GiftWrapDecorator(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " +Gift Wrapping";
    }

    @Override
    public double getPrice() {
        return product.getPrice() + WRAP_COST;
    }
}
