package zh.tbz;

public class RentalService {
    private Repository<Car> repository;

    public RentalService(Repository<Car> repository) {
        this.repository = repository;
    }

    public boolean rentCar(String name, int days, PricingPolicy pricingPolicy, PaymentGateway paymentGateway) {
    Car car = repository.get(name);
    if (car != null && car.isAvailable()) {
        double price = pricingPolicy.calculatePrice(days);
        if (paymentGateway.charge(price)) {
            car.rent();
            System.out.println("Car rented: " + car.getName() + "\nprice: " + price);
            return true;
        }
    }
    return false;
    }

    public void returnCar(String name) {
        Car car = repository.get(name);
        if (car != null) car.returnVehicle();
    }

    public void listAvailableCars() {
        for (Car car : repository.getAll()) {
            if (car.isAvailable()) {
                System.out.println(car.getName());
            }
        }
    }



}
