package ch.tbz.exception;

/**
 * Thrown when a user attempts to checkout with an empty shopping cart.
 */
public class EmptyCartException extends RuntimeException {

    /**
     * Constructs a new EmptyCartException with the detail message.
     *
     * @param message the detail message
     */
    public EmptyCartException(String message) {
        super(message);
    }
}
