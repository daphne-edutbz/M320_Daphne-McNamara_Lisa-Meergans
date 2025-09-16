package ch.tbz;

/**
 * Basisclass for all vehicles
 * includes attributes such as brand, model, build year and the repared status
 * Subclasses override the method {@link #calculateCost()} for specific calculations
 *
 * @author daphne
 * @version 1.0
 */



public class Vehicles {
    private String brand;
    private String model;
    private int year;
    private Boolean repared;

    /**
     * Constructor for vehicles class
     *
     * @param brand brand of vehicle
     * @param model Model of vehicle
     * @param year  buildyear
     */

    public Vehicles(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.repared = false;
    }

    /**
     * Set repare status of vehicle
     *
     * @param repared new Status (true = repared)
     */
    public void setRepared(Boolean repared) {
        this.repared = repared;
    }


    /**
     * Calculates  repair costs.
     * Default implementation returns {@code 0.0} and is overridden in subclasses.
     *
     * @return Repair costs as double
     */
    public double calculateCost() {
        return 0.0; // default
    }


    /**
     * Overloaded method for calculating repair costs with additional working hours.
     *
     * @param extraWorkHours Additional working hours
     * @return Total costs (base price + $50.0 per hour)
     */

    public double calculateCost(int extraWorkHours) {
        return calculateCost() + extraWorkHours * 50.0;
    }


    /**
     * Returns a string representation of the vehicle.
     *
     * @return Information about the make, model, year, and repair status.
     */
    @Override
    public String toString() {
        return "\nVehicle: " + brand + ", " + model + " (" + year + ")\nrepared: " + repared;
    }
}
