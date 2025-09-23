package zh.tbz;

public class Car implements Rentable{
    private String name;
    private boolean available;

    public Car(String name, boolean available) {
        this.name = name;
        this.available = available;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void rent() {
        if(available){
            available = false;
            System.out.println(name + " rented");
        } else {
            System.out.println(name + " is not available");
        }
    }

    @Override
    public void returnVehicle(){
        available = true;
        System.out.println(name + " returned");
    }
}
