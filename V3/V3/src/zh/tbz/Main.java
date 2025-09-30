package zh.tbz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repository<Car> repo = new CarRepository();
        RentalService service = new RentalService(repo);

        PaymentGateway gateway = new PaymentGateway() {
            @Override
            public boolean charge(double amount) {
                System.out.println("Charged: " + amount + " CHF");
                return true;
            }
        };

        repo.add(new Car("Mercedes", true));
        repo.add(new Car("Audi", true));
        repo.add(new Car("BMW", true));

        PricingPolicy flat = new FlatRatePolicy(50);
        PricingPolicy discount = new DiscountPolicy(50, 0.2);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Car Rental Menu ===");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. List available cars");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable cars:");
                    service.listAvailableCars();

                    System.out.print("Enter the car you want to rent: ");
                    String carName = scanner.nextLine();

                    System.out.print("How many days? ");
                    int days = scanner.nextInt();

                    System.out.print("Choose pricing policy (1 = FlatRate, 2 = Discount): ");
                    int policyChoice = scanner.nextInt();
                    scanner.nextLine();

                    PricingPolicy chosenPolicy = (policyChoice == 2) ? discount : flat;

                    boolean success = service.rentCar(carName, days, chosenPolicy, gateway);
                    if (!success) {
                        System.out.println("Could not rent the car. Maybe it's unavailable?");
                    }
                    break;

                case 2:
                    System.out.print("\nEnter the name of the car to return: ");
                    String returnName = scanner.nextLine();
                    service.returnCar(returnName);
                    break;

                case 3:
                    System.out.println("\nAvailable cars:");
                    service.listAvailableCars();
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }

        scanner.close();
    }
}