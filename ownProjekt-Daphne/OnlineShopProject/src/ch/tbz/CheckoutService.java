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

        double originalTotal = order.getTotalPrice();
        double discountAmount = discount.calculateDiscount(originalTotal);
        order.applyDiscount(discount); // Strategy pattern

        System.out.println("\n--- Checkout Summary ---");
        System.out.println("Original total: " + originalTotal + " CHF");
        System.out.println("Discount (" + discount.getClass().getSimpleName() + "): -" + discountAmount + " CHF");
        System.out.println("Final total: " + order.getTotalPrice() + " CHF");
        System.out.println("------------------------");

        paymentService.pay(order, "Credit Card");
        repo.saveOrder(order);
        new PurchaseReceipt(order).printReceipt();
    }

}
