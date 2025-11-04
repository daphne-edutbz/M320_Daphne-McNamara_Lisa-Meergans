package ch.tbz;

import ch.tbz.discount.DiscountStrategy;
import ch.tbz.discount.FixedAmountDiscount;
import ch.tbz.discount.NoDiscount;
import ch.tbz.discount.PercentageDiscount;
import ch.tbz.model.*;
import ch.tbz.repository.OrderRepository;
import ch.tbz.repository.Repository;
import ch.tbz.service.CheckoutService;
import ch.tbz.service.PaymentService;
import ch.tbz.util.OrderFileWriter;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Demo mode: show examples with all discounts and repositories
        demoMode();

        // UserInterface
        userInterfaceMode();
    }

    private static void demoMode() {
        System.out.println("\n=== DEMO MODE ===");

        // Services
        PaymentService paymentService = new PaymentService();
        CheckoutService checkoutService = new CheckoutService();
        Repository<Order> genericOrderRepo = new Repository<>();
        OrderRepository orderRepository = new OrderRepository();

        User demoUser = new User(1, "Daphne McNamara");

        Product laptop = new ElectronicProduct(1, "Laptop", 499.99);
        Product phone = new ElectronicProduct(2, "iPhone", 899.99);
        Product apple = new FoodProduct(3, "Apple", 1.50);

        Product wrappedLaptop = new ch.tbz.model.GiftWrapDecorator(laptop);
        demoUser.addToCart(wrappedLaptop);
        demoUser.addToCart(phone);
        demoUser.addToCart(apple);

        System.out.println("\nCart:");
        demoUser.getCart().showItems();

        DiscountStrategy[] discounts = {
                new NoDiscount(),
                new PercentageDiscount(10),
                new FixedAmountDiscount(50)
        };

        for (DiscountStrategy discount : discounts) {
            System.out.println("\n=== Checkout with discount: " + discount.getClass().getSimpleName() + " ===");
            demoUser.checkout(checkoutService, discount, paymentService, orderRepository);
            Order latestOrder = orderRepository.getAllOrders().get(orderRepository.getAllOrders().size() - 1);
            genericOrderRepo.save(latestOrder);
        }

        System.out.println("\nSaved Orders (OrderRepository):");
        orderRepository.getAllOrders().forEach(System.out::println);
        OrderFileWriter.saveOrdersToFile(orderRepository.getAllOrders());


        System.out.println("\nSaved Orders (Generic Repository<T>):");
        genericOrderRepo.getAll().forEach(System.out::println);
        OrderFileWriter.saveOrdersToFile(genericOrderRepo.getAll());

    }

    private static void userInterfaceMode() {
        System.out.println("\n=== Online shop ===");
        Scanner scanner = new Scanner(System.in);

        PaymentService paymentService = new PaymentService();
        CheckoutService checkoutService = new CheckoutService();
        OrderRepository orderRepository = new OrderRepository();

        User user = new User(2, "Customer");

        Product[] products = {
                new ElectronicProduct(1, "Laptop", 499.99),
                new ElectronicProduct(2, "iPhone", 899.99),
                new FoodProduct(3, "Apple", 1.50)
        };

        boolean running = true;
        while (running) {
            System.out.println("\n1) Show products");
            System.out.println("2) Add product to cart");
            System.out.println("3) Show cart");
            System.out.println("4) Checkout");
            System.out.println("5) Remove product from cart");
            System.out.println("6) Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nAvailable products:");
                    for (Product p : products) {
                        System.out.println(p.getId() + ") " + p.getDescription());
                    }
                }
                case 2 -> {
                    System.out.println("\nAvailable products to add:");
                    for (Product p : products) {
                        System.out.println(p.getId() + ") " + p.getDescription());
                    }

                    System.out.print("Enter product ID to add: ");
                    int productId = scanner.nextInt();
                    Product selected = null;
                    for (Product p : products) {
                        if (p.getId() == productId) selected = p;
                    }

                    if (selected != null) {
                        System.out.print("Do you want gift wrapping for this product? (y/n): ");
                        String wrap = scanner.next();
                        if (wrap.equalsIgnoreCase("y")) {
                            selected = new GiftWrapDecorator(selected);
                        }

                        System.out.print("How many of this product do you want to add? ");
                        int quantity = scanner.nextInt();
                        for (int i = 0; i < quantity; i++) {
                            user.addToCart(selected);
                        }

                        System.out.println(quantity + " x " + selected.getDescription() + " added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 3 -> {
                    System.out.println("\nYour cart:");
                    user.getCart().showItems();
                    System.out.println("Total: " + user.getCart().getTotal() + " CHF");
                }
                case 4 -> {
                    System.out.println("\nChoose discount:");
                    System.out.println("1) No discount");
                    System.out.println("2) 10% off");
                    System.out.println("3) 50 CHF off");
                    int d = scanner.nextInt();
                    DiscountStrategy discount = switch (d) {
                        case 2 -> new PercentageDiscount(10);
                        case 3 -> new FixedAmountDiscount(50);
                        default -> new NoDiscount();
                    };
                    user.checkout(checkoutService, discount, paymentService, orderRepository);
                    OrderFileWriter.saveOrdersToFile(orderRepository.getAllOrders());
                }
                case 5 -> {
                    System.out.println("\nYour cart:");
                    Cart cart = user.getCart();
                    cart.showItems();

                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();

                    System.out.print("How many of this product to remove? ");
                    int qty = scanner.nextInt();

                    int removedCount = 0;
                    Iterator<Product> it = cart.getItems().iterator();
                    while (it.hasNext() && removedCount < qty) {
                        if (it.next().getId() == removeId) {
                            it.remove();
                            removedCount++;
                        }
                    }

                    if (removedCount > 0) {
                        System.out.println(removedCount + " item(s) removed from cart.");
                    } else {
                        System.out.println("Product not found in cart.");
                    }
                }
                case 6 -> {
                    System.out.println("Exiting online shop.");
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
