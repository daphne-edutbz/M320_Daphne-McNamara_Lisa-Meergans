package ch.tbz;

/**
 * A goalkeeper is a player specialized in defending the goal.
 * Overrides method train in player with goalkeeper-specific training.
 * @author Lisa
 * @version 1.0
 */
public class Goalkeeper extends Player {

    /**
     * Creates a new goalkeeper.
     *
     * @param name    goalkeeper's name
     * @param age     goalkeeper's age
     * @param fitness initial fitness value
     */
    public Goalkeeper(String name, int age, int fitness) {
        super(name, age, fitness);
    }

    /** Increases fitness by 7 and prints a goalkeeper-specific message. */
    @Override
    public void train() {
        setFitness(getFitness() + 7);
        System.out.println(getName() + " trains goalkeeper practice. Fitness: " + getFitness());
    }
}
