package ch.tbz;

public class PaymentService {

    public void pay(Order order, String paymentMethod) {
        System.out.println("Payment method: " + paymentMethod);
        System.out.println("Payment successful for amount: " + order.getTotalPrice() + " CHF");
    }
}
