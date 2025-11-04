package ch.tbz.model;

import ch.tbz.discount.DiscountStrategy;

import java.util.List;

/**
 * Represents a completed order in the shop
 * Stores list of products, total price and allows discount application
 */
public class Order {
    private int id;
    private List<Product> items;
    private double totalPrice;

    public Order(int id, List<Product> items, double totalPrice) {
        this.id = id;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /** Apply discount strategy */
    public void applyDiscount(DiscountStrategy strategy) {
        double discount = strategy.calculateDiscount(totalPrice);
        totalPrice -= discount;
    }

    @Override
    public String toString() {
        return "Order #" + id + " total: " + totalPrice + " CHF";
    }
}
