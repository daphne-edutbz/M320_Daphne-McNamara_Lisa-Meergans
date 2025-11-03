package ch.tbz;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Daphne McNamara");

        Product laptop = new Product(1, "Laptop", 499.99);
        Product phone = new Product(2, "iPhone", 899.99);

        // Design pattern (Decorator, Gift Wrap)
        Product wrappedLaptop = new GiftWrapDecorator(laptop);

        // Delegation: user -> cart logic
        user.addToCart(wrappedLaptop);
        user.addToCart(phone);

        System.out.println("\nCart:");
        user.getCart().showItems();

        // Design Pattern (Strategy, Discount) -> "choose a discount"
        DiscountStrategy discount = new PercentageDiscount(10);

        // Delegation to services
        PaymentService paymentService = new PaymentService();
        OrderRepository orderRepository = new OrderRepository();

        user.checkout(orderRepository, paymentService, discount);

        System.out.println("\nSaved Orders:");
        orderRepository.getAllOrders().forEach(System.out::println);
    }
}
