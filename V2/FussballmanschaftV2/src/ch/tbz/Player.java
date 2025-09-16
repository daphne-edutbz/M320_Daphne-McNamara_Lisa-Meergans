package ch.tbz;

/**
 * Base class for all football players.
 * Holds common attributes such as name, age and fitness level.
 * @author Lisa
 * @version 1.0
 */
public class Player {

    private String name;
    private int age;
    private int fitness;

    /**
     * Creates a new player.
     *
     * @param name    player's name
     * @param age     player's age
     * @param fitness initial fitness level
     */
    public Player(String name, int age, int fitness) {
        this.name = name;
        this.age = age;
        this.fitness = fitness;
    }

    /** training that increases fitness by 5. */
    public void train() {
        fitness += 5;
        System.out.println(name + " is training. Fitness: " + fitness);
    }

    /**
     * Training with a specified intensity.
     *
     * @param intensity value by which fitness increases
     */
    public void train(int intensity) {
        fitness += intensity;
        System.out.println(name + " is training with intensity " + intensity +
                ". Fitness: " + fitness);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
}
