package ch.tbz;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart represents a shopping cart for a user.

 * Manages products added by the user, calculates total price and shows items.
 * HAT relationship: User has a Cart
 */
public class Cart {
    private List<Product> items = new ArrayList<>();

    /** Add a product to the cart */
    public void addItem(Product product) {
        items.add(product);
    }

    /** Remove a product from the cart */
    public void removeItem(Product product) {
        items.remove(product);
    }

    /** Calculate total price of items in the cart */
    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    /** Get list of items */
    public List<Product> getItems() {
        return items;
    }

    /** Print all items in the cart */
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            items.forEach(System.out::println);
        }
    }
}
