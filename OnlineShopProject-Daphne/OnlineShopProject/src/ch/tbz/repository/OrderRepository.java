package ch.tbz.repository;

import ch.tbz.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository to store completed orders
 * Demonstrates simple persistence (in-memory list)
 */
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    private static int orderCounter = 1;

    /** Save an order to repository */
    public void saveOrder(Order order) {
        order.setId(orderCounter++);
        orders.add(order);
    }
    /** Return all saved orders */

    public List<Order> getAllOrders() {
        return orders;
    }}
