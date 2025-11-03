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

    public void checkout(CheckoutService service, DiscountStrategy discount, PaymentService paymentService, OrderRepository repo) {
        if (cart.getItems().isEmpty()) {
            throw new EmptyCartException("Cart is empty, cannot checkout an empty cart.");
        }
        service.processOrder(this, discount, paymentService, repo);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
