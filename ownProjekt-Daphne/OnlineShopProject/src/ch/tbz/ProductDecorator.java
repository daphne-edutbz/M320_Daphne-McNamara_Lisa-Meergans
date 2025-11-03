package ch.tbz;

//Design Pattern (Decorator, gift wrapping)
public abstract class ProductDecorator extends Product {
    protected Product product; //Product that is being decorated

    public ProductDecorator(Product product) {
        super(product.getId(), product.getName(), product.getPrice());
        this.product = product;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getPrice();
}
