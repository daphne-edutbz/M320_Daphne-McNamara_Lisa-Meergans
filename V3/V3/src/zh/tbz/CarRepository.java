package zh.tbz;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements Repository<Car> {
    private List<Car> cars = new ArrayList<>();

    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public void remove(Car car) {
        cars.remove(car);
    }

    @Override
    public Car get(String name) {
        return cars.stream().filter(car -> car.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Car> getAll() {
        return new ArrayList<>(cars);
    }

    public List<Car> getAvailable() {
        return cars.stream()
                .filter(Car::isAvailable)
                .toList();
    }

    @Override
    public void remove(String name) {
        Car toRemove = null;
        for (Car car : cars) {
            if (car.getName().equalsIgnoreCase(name)) {
                toRemove = car;
                break;
            }
        }
        if (toRemove != null) {
            cars.remove(toRemove);
        }
    }



    }
