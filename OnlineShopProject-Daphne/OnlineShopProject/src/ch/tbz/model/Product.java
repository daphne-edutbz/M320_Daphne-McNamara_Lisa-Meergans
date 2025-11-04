package ch.tbz.model;

/**
 * Base Product class.
 * Polymorphism: can be subclassed into ElectronicProduct, FoodProduct.
 * Decorator pattern: can be wrapped with ProductDecorator.
 */
public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /** Returns product description */
    public String getDescription() {
        return name + " - " + price + " CHF";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
