package ch.tbz;

public class User {
    private int id;
    private String name;
    private Cart cart = new Cart();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void checkout(OrderRepository repo, PaymentService paymentService, DiscountStrategy discount) {
        if (cart.getItems().isEmpty()) {
            throw new EmptyCartException("Cart is empty, cannot checkout an empty cart.");
        }
        Order order = new Order(id, cart.getItems(), cart.getTotal());
        order.applyDiscount(discount);
        paymentService.pay(order, "Credit Card");
        repo.saveOrder(order);
        System.out.println("Order #" + id + " has been placed: " + order);

        PurchaseReceipt receipt = new PurchaseReceipt(order);
        receipt.printReceipt();

    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
