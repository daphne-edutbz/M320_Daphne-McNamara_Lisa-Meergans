package ch.tbz;

/**
 * CheckoutService handles the actual order processing.
 * Demonstrates delegation pattern: User delegates checkout to this service.
 */
public class CheckoutService {

    /**
     * Process the order for a user:
     * 1. Create Order from cart
     * 2. Apply discount
     * 3. Pay via PaymentService
     * 4. Save in OrderRepository
     * 5. Print receipt
     */
    public void processOrder(User user, DiscountStrategy discount, PaymentService paymentService, OrderRepository repo) {
        Order order = new Order(user.getId(), user.getCart().getItems(), user.getCart().getTotal());
        order.applyDiscount(discount); // Strategy pattern
        paymentService.pay(order, "Credit Card");
        repo.saveOrder(order);
        System.out.println("Order #" + user.getId() + " has been placed: " + order);
        new PurchaseReceipt(order).printReceipt();
    }
}
