package ch.tbz;

/**
 * represents  motorbike as a "Spezialisierung" of  {@link Vehicles}.
 * overrides calculation of repare costs
 *
 * @author daphne
 * @version 1.0
 */

public class Motorbike extends Vehicles{

    /**
     * Constructor for motorbike class
     *
     * @param brand brand of motorbike
     * @param model model description
     * @param year  year when it was built
     */

    public Motorbike(String brand, String model, int year) {
        super(brand, model, year);
    }

    /**
     * calculates repare cost for motobikes
     *
     * @return repare cost as double (Standard: 300.00)
     */

    @Override
    public double calculateCost() {
        return 300.00; //default cost for fixing car
    }
}
