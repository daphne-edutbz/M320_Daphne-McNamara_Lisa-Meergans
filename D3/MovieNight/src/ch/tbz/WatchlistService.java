package ch.tbz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WatchlistService {
    private static final String FILE_PATH = "watchlist.txt";
    private List<Movie> watchlist;
    private static final int MAX_SIZE = 20;

    public WatchlistService() {
        watchlist = loadWatchlist();
    }


    public void addMovie(Movie movie) throws WatchlistFullException, PersistenceException {
        if (watchlist.size() >= MAX_SIZE) {
            throw new WatchlistFullException("Watchlist is full (max " + MAX_SIZE + ")");
        }
        watchlist.add(movie);
        saveWatchlist();
    }

    public List<Movie> getWatchlist() {
        return watchlist;
    }

    private void saveWatchlist() throws PersistenceException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Movie m : watchlist) {
                writer.println(m.getTitle() + ";" + m.getYear() + ";" + m.getGenre() + ";" +
                        m.getDirector() + ";" + m.getImdbRating());
            }
        } catch (IOException e) {
            throw new PersistenceException("Failed to save watchlist.");
        }
    }

    private List<Movie> loadWatchlist() {
        List<Movie> watchlist = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return watchlist;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] split = line.split(";");
                if (split.length == 5){
                    watchlist.add(new Movie(split[0], split[1], split[2], split[3], split[4]));
                }
            }
        } catch (IOException e) {

        }
        return watchlist;
    }

}
