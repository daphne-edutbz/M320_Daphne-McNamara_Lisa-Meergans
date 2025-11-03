package ch.tbz;

public class PurchaseReceipt {
    private Order order;

    public PurchaseReceipt(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        System.out.println("\n--- Receipt ---");
        for (Product p : order.getItems()) {
            System.out.println(p.getDescription());
        }
        System.out.println("Total: " + order.getTotalPrice() + " CHF");
        System.out.println("----------------");
    }
}
