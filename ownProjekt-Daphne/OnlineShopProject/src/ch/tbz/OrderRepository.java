package ch.tbz;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository to store completed orders
 * Demonstrates simple persistence (in-memory list)
 */
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    /** Save an order to repository */
    public void saveOrder(Order order) {
        orders.add(order);
    }

    /** Return all saved orders */
    public List<Order> getAllOrders() {
        return orders;
    }
}
