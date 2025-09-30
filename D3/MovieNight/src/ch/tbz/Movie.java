package ch.tbz;

public class Movie {
    private String title;
    private String year;
    private String genre;
    private String director;
    private String imdbRating;

    public Movie(String title, String year, String genre, String director, String imdbRating) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.imdbRating = imdbRating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }
    public String getImdbRating() {
        return imdbRating;
    }
}
