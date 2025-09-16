package ch.tbz;

/**
 * represents  trucks as a "Spezialisierung" of  {@link Vehicles}.
 * overrides calculation of repare costs
 *
 * @author daphne
 * @version 1.0
 */

public class Truck extends Vehicles{

    /**
     * Constructor for motorbike class
     *
     * @param brand brand of motorbike
     * @param model model description
     * @param year  year when it was built
     */
    
    public Truck(String brand, String model, int year) {
        super(brand, model, year);
    }

    /**
     * calculates repare cost for motobikes
     *
     * @return repare cost as double (Standard: 300.00)
     */

    @Override
    public double calculateCost() {
        return 800.00; //default cost for fixing car
    }
}
