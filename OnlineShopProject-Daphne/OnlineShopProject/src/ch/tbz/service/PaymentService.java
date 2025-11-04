package ch.tbz.service;

import ch.tbz.model.Order;
import ch.tbz.exception.PaymentFailedException;

/**
 * Handles payment processing
 * Throws PaymentFailedException if payment is invalid.
 */
public class PaymentService {

    public void pay(Order order, String paymentMethod) {
        if(order.getTotalPrice() <= 0)
            throw new PaymentFailedException("Payment failed. Cannot pay zero amount");
        System.out.println("Payment method: " + paymentMethod);
        System.out.println("Payment successful for amount: " + order.getTotalPrice() + " CHF");
    }
}
