package ch.tbz.exception;

/**
 * Thrown when a payment attempt fails (for example: invalid amount or method).
 */
public class PaymentFailedException extends RuntimeException {

    /**
     * Constructs a new PaymentFailedException with the detail message.
     *
     * @param message the detail message
     */
    public PaymentFailedException(String message) {
        super(message);
    }
}
