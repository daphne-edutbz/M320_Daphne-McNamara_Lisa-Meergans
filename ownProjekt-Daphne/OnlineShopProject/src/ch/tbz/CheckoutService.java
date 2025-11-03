package ch.tbz;

public class CheckoutService {

    public void processOrder(User user, DiscountStrategy discount, PaymentService paymentService, OrderRepository repo) {
        Order order = new Order(user.getId(), user.getCart().getItems(), user.getCart().getTotal());
        order.applyDiscount(discount);
        paymentService.pay(order, "Credit Card");
        repo.saveOrder(order);
        System.out.println("Order #" + user.getId() + " has been placed: " + order);
        new PurchaseReceipt(order).printReceipt();
    }
}

