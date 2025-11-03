package ch.tbz;

public class Main {
    public static void main(String[] args) {
        // Create services and repository once (delegation example)
        PaymentService paymentService = new PaymentService();
        OrderRepository orderRepository = new OrderRepository();
        CheckoutService checkoutService = new CheckoutService();

        // Create a user
        User user = new User(1, "Daphne McNamara");

        // Create products
        Product laptop = new ElectronicProduct(1, "Laptop", 499.99);
        Product phone = new ElectronicProduct(2, "iPhone", 899.99);
        Product apple = new FoodProduct(3, "Apple", 2);

        // Decorator pattern: gift wrap the laptop
        Product wrappedLaptop = new GiftWrapDecorator(laptop);

        // Delegation: add products to cart via User
        user.addToCart(wrappedLaptop);
        user.addToCart(phone);
        user.addToCart(apple);

        // Show cart
        System.out.println("\nCart:");
        user.getCart().showItems();

        // Strategy pattern: apply discount
        DiscountStrategy discount = new PercentageDiscount(10);

        // Checkout using delegation to CheckoutService
        user.checkout(checkoutService, discount, paymentService, orderRepository);

        // Show saved orders
        System.out.println("\nSaved Orders:");
        orderRepository.getAllOrders().forEach(System.out::println);
    }
}

