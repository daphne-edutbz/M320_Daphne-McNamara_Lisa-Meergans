package ch.tbz;

import java.util.Scanner;

public class MovieController {
    private MovieService service = new MovieService();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("=== MovieNight ===");
            System.out.println("1. Search movie");
            System.out.println("2. Show watchlist");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchMovieFlow();
                    break;
                case "2":
                    service.showWatchlist();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void searchMovieFlow() {
        try {
            System.out.print("Enter movie title: ");
            String title = scanner.nextLine();
            Movie movie = service.searchMovie(title);

            System.out.println("\nTitle: " + movie.getTitle());
            System.out.println("Year: " + movie.getYear());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("IMDb Rating: " + movie.getImdbRating());

            System.out.print("\nAdd to watchlist? (y/n): ");
            String add = scanner.nextLine();
            if (add.equalsIgnoreCase("y")) {
                service.addToWatchlist(movie);
                System.out.println("Added to watchlist.");
            }
        } catch (MovieNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (WatchlistFullException | PersistenceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

