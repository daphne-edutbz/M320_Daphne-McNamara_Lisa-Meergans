package ch.tbz;

/**
 * A striker is a player specialized in scoring goals.
 * Overrides method train in player with striker-specific training.
 * @author Lisa
 * @version 1.0
 */
public class Striker extends Player {

    /**
     * Creates a new striker.
     *
     * @param name    striker's name
     * @param age     striker's age
     * @param fitness initial fitness value
     */
    public Striker(String name, int age, int fitness) {
        super(name, age, fitness);
    }

    /** Increases fitness by 8 and prints a striker-specific message. */
    @Override
    public void train() {
        setFitness(getFitness() + 8);
        System.out.println(getName() + " trains goal shots. Fitness: " + getFitness());
    }
}
