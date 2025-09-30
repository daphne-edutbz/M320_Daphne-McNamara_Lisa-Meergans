package tbz.ch;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Player player;
    private Playlist playlist;
    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);
        playlist = new Playlist(new ArrayList<>());
        player = new Player();
        player.setPlaylist(playlist);

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:\n 1-Add Song\n 2-Remove Song\n 3-Play All\n 4-Shuffle\n 5-Play Song\n 6-Current Playlist\n 7-Exit");
            System.out.println("Input: ");
            int choice = scanner.nextInt();
            scanner.nextLine();



            switch (choice) {
                case 1:
                    System.out.println("Enter song title: ");
                    String title = scanner.nextLine();

                    System.out.println("Enter song artist: ");
                    String artist = scanner.nextLine();

                    System.out.println("Enter song duration (seconds): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();

                    Song song = new Song(title, artist, duration);
                    playlist.addSong(song);

                    System.out.println("Song added: " + song);
                    break;

                case 2:
                    System.out.println("Enter song title to remove: ");
                    String removeTitle = scanner.nextLine();

                    try{
                        Song toRemove = null;
                        for (Song s : playlist.getSongs()) {
                            if (s.getTitle().equals(removeTitle)) {
                                toRemove = s;
                                break;
                            }
                        }
                        if (toRemove != null) {
                            playlist.removeSong(toRemove);
                            System.out.println("Song removed: " + toRemove);
                        } else {
                            throw new SongNotFoundException("Song not found: " + removeTitle);
                        }
                    } catch (SongNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        player.playAll();
                    }catch (PlaylistEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        player.shufflePlay();
                    }catch (PlaylistEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Enter song title to play: ");
                    String playTitle = scanner.nextLine();

                    try {
                        player.playSong(playTitle);
                    } catch (PlaylistEmptyException | SongNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty!");
                    } else {
                        System.out.println("Current Playlist:");
                        for (Song s : playlist.getSongs()) {
                            System.out.println("- " + s.getTitle() + " by " + s.getArtist() + " (" + s.getDuration() + "s)");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    running = false;
                    break;


            }

        }

    }
}
