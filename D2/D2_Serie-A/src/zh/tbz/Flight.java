package zh.tbz;

import java.util.ArrayList;

public class Flight {

    private int flightNumber;
    private ArrayList<Passenger> passengers;

    public Flight(int flightNumber, ArrayList<Passenger> passengers) {
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<>();
    }

    public void showPassengers() {
        if (this.passengers.isEmpty()) {
            System.out.println("No passengers found on flight " + flightNumber);
        } else {
            System.out.println("Passengers on flight " + flightNumber + ":");
            for (Passenger p : passengers) {
                System.out.println(" - " + p.getName());
            }
        }
    }

    public void addPassenger(Passenger passenger) {
        if (findPassenger(passenger.getName()) == null) {
            passengers.add(passenger);
        } else {
            System.out.println(passenger.getName() + " is already on flight " + flightNumber);
        }
    }

    public void removePassenger(Passenger p) {
        Passenger toRemove = null;
        for (Passenger passenger : this.passengers) {
            if (passenger.getName().equalsIgnoreCase(p.getName())) {
                toRemove = passenger;
                break;
            }
        }
        if (toRemove != null) {
            this.passengers.remove(toRemove);
            System.out.println(p.getName() + " has been removed");
        } else {
            System.out.println(p.getName() + " not found");
        }
    }

    public Passenger findPassenger(String name) {
        for (Passenger p : passengers) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}
