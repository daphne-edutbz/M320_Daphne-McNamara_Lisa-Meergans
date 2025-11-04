package ch.tbz.model;

/**
 * Electronic product subclass of Product.
 * Demonstrates polymorphism.
 */
public class ElectronicProduct extends Product {
    public ElectronicProduct(int id, String name, double price) {
        super(id, name, price);
    }
}
