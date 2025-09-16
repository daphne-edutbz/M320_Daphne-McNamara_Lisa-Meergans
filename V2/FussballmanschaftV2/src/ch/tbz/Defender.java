package ch.tbz;

/**
 * A defender is a player specialized in duels and blocking attacks.
 * Overrides method train in player with defender-specific training.
 * @author Lisa
 * @version 1.0
 */
public class Defender extends Player {

    /**
     * Creates a new defender.
     *
     * @param name    defender's name
     * @param age     defender's age
     * @param fitness initial fitness value
     */
    public Defender(String name, int age, int fitness) {
        super(name, age, fitness);
    }

    /** Increases fitness by 6 and prints a defender-specific message. */
    @Override
    public void train() {
        setFitness(getFitness() + 6);
        System.out.println(getName() + " trains duels. Fitness: " + getFitness());
    }
}
