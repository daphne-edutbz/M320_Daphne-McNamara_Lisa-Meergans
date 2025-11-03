package ch.tbz;

/**
 * Generates and prints a receipt for an order.
 */
public class PurchaseReceipt {
    private Order order;

    public PurchaseReceipt(Order order) {
        this.order = order;
    }

    /** Prints formatted receipt */
    public void printReceipt() {
        System.out.println("\n--- Receipt ---");
        for (Product p : order.getItems()) {
            System.out.println(p.getDescription());
        }
        System.out.println("Total: " + order.getTotalPrice() + " CHF");
        System.out.println("----------------");
    }
}
