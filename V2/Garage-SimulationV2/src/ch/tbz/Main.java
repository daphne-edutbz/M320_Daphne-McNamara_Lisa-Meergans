package ch.tbz;

/**
 * Main class for demonstrating inheritance,
 * overriding, and overloading in a vehicle hierarchy.
 *
 * @author daphne
 * @version 1.0
 */

public class Main {
    /**
     * Entry point of the program.
     * Creates various vehicles and displays their repair costs.
     *
     * @param args is not used
     */
    public static void main(String[] args) {
        /**
         * This is the main method
         * the entry point of the program
         * creates vehicles and shows the repare cost
         *
         * @param args not used
         */

        //vehicles are declared with polymorphism
        Vehicles v1= new Car("Mercedes", "C-class", 1992);
        Vehicles v2= new Truck("Ford", "F-150", 1948);
        Vehicles v3= new Motorbike("Yamaha", "MT-07",2015);

        System.out.println(v1);
        System.out.println("Überschreibung:");
        System.out.println("Repare cost: " + v1.calculateCost());

        System.out.println("überladung: ");
        System.out.println("Cost with 2 hours extra work: " + v1.calculateCost(2));


        System.out.println(v2);
        System.out.println("Repare cost: " + v2.calculateCost());

        System.out.println(v3);
        System.out.println("Repare cost: " + v3.calculateCost());

        v1.setRepared(true);
        System.out.println("\nFix/Repare Vehicle 1:" + v1);


    }
}