package ch.tbz;

public class Main {
    public static void main(String[] args) {
        // Services
        PaymentService paymentService = new PaymentService();
        CheckoutService checkoutService = new CheckoutService();

        // Generic repository for Orders (demonstrates generics)
        Repository<Order> genericOrderRepo = new Repository<>();

        // Specialized repository for Orders
        OrderRepository orderRepository = new OrderRepository();

        // Create a user
        User user = new User(1, "Daphne McNamara");

        // Create products
        Product laptop = new ElectronicProduct(1, "Laptop", 499.99);
        Product phone = new ElectronicProduct(2, "iPhone", 899.99);
        Product apple = new FoodProduct(3, "Apple", 1.50);

        // Decorator pattern: gift wrap the laptop
        Product wrappedLaptop = new GiftWrapDecorator(laptop);

        // Add products to cart (delegation to Cart)
        user.addToCart(wrappedLaptop);
        user.addToCart(phone);
        user.addToCart(apple);

        // Show cart items
        System.out.println("\nCart:");
        user.getCart().showItems();

        // different discount strategies
        DiscountStrategy[] discounts = {
                new NoDiscount(),
                new PercentageDiscount(10),
                new FixedAmountDiscount(50)
        };

        for (DiscountStrategy discount : discounts) {
            System.out.println("\n=== Checkout with discount: " + discount.getClass().getSimpleName() + " ===");
            // Checkout
            user.checkout(checkoutService, discount, paymentService, orderRepository);

            // Also save in generic repository
            Order latestOrder = orderRepository.getAllOrders().get(orderRepository.getAllOrders().size() - 1);
            genericOrderRepo.save(latestOrder);
        }

        // Show saved orders from specialized repository
        System.out.println("\nSaved Orders (OrderRepository):");
        orderRepository.getAllOrders().forEach(System.out::println);

        // Show saved orders from generic repository
        System.out.println("\nSaved Orders (Generic Repository<T>):");
        genericOrderRepo.getAll().forEach(System.out::println);
    }
}
