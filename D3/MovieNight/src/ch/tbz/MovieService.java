package ch.tbz;

public class MovieService {
    private OmdbApiService apiService = new OmdbApiService();
    private WatchlistService watchlistService = new WatchlistService();

    public Movie searchMovie(String title) throws MovieNotFoundException {
        return apiService.getMovieByTitle(title);
    }

    public void addToWatchlist(Movie movie) throws WatchlistFullException, PersistenceException {
        watchlistService.addMovie(movie);
    }

    public void showWatchlist() {
        var list = watchlistService.getWatchlist();
        if (list.isEmpty()) {
            System.out.println("Watchlist is empty");
            return;
        }
        System.out.println("== Watchlist ==");
        for (Movie m : list) {
            System.out.println(m.getTitle() + " (" + m.getYear() + ")");
        }
        System.out.println("===============");
    }
}
