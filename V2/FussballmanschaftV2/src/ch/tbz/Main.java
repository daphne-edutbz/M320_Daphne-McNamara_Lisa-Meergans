package ch.tbz;

/**
 * Demonstrates creation of a football team and training its players.
 * @author Lisa
 * @version 1.0v
 */
public class Main {
    public static void main(String[] args) {
        FootballTeam footballTeam = new FootballTeam();

        footballTeam.addPlayer(new Goalkeeper("Neuer", 37, 50));
        footballTeam.addPlayer(new Defender("de Ligt", 37, 50));
        footballTeam.addPlayer(new Striker("Kane", 37, 50));

        System.out.println();

        footballTeam.trainAll();
        footballTeam.trainAll();

        System.out.println();
        footballTeam.trainAllWithIntensity(15);
    }
}
