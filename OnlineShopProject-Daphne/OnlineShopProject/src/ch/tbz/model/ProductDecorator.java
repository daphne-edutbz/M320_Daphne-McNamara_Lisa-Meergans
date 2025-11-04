package ch.tbz.model;

/**
 * Abstract decorator for Product (Decorator pattern)
 * Allows addition of features, for example gift wrapping
 */
public abstract class ProductDecorator extends Product {
    protected Product product; // Product being decorated

    public ProductDecorator(Product product) {
        super(product.getId(), product.getName(), product.getPrice());
        this.product = product;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getPrice();
}
