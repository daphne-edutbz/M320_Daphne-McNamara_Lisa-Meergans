package ch.tbz;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a football team with a maximum of 11 players.
 * Provides methods to add players and train them.
 * @author Lisa
 * @version 1.0
 */
public class FootballTeam {

    /** Internal list that stores all players of the team. */
    private final List<Player> playerlist = new ArrayList<>();

    /**
     * Adds a player to the team if there is space left.
     *
     * @param player the player to add
     */
    public void addPlayer(Player player) {
        // A football team may have at most 11 players
        if (playerlist.size() < 11) {
            playerlist.add(player);
            System.out.println(player.getName() + " added to team");
        } else {
            System.out.println("A team contains only 11 players");
        }
    }

    /** Trains all players with their individual training routines. */
    public void trainAll() {
        for (Player player : playerlist) {
            player.train();
        }
    }

    /**
     * Trains all players with a given intensity.
     *
     * @param intensity the training intensity to apply to every player
     */
    public void trainAllWithIntensity(int intensity) {
        for (Player player : playerlist) {
            player.train(intensity);
        }
    }
}
