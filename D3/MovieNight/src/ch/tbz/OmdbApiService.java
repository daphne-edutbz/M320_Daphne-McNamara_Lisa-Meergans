package ch.tbz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OmdbApiService {
    private static final String API_KEY = "d0ea317d";

    public Movie getMovieByTitle(String title) throws MovieNotFoundException {
        try {
            String urlString = "http://www.omdbapi.com/?t=" + title.replace(" ", "+") + "&apikey=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int status = conn.getResponseCode();
            if (status != 200) {
                throw new MovieNotFoundException("HTTP Error: " + status);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String json = response.toString();

            if (json.contains("\"Error\"")) {
                throw new MovieNotFoundException("Movie not found.");
            }

            String titleValue = extractJsonValue(json, "Title");
            String year = extractJsonValue(json, "Year");
            String genre = extractJsonValue(json, "Genre");
            String director = extractJsonValue(json, "Director");
            String imdbRating = extractJsonValue(json, "imdbRating");

            return new Movie(titleValue, year, genre, director, imdbRating);

        } catch (Exception e) {
            throw new MovieNotFoundException("Movie could not be retrieved: " + e.getMessage());
        }
    }

    private String extractJsonValue(String json, String key) {
        String search = "\"" + key + "\":\"";
        int start = json.indexOf(search);
        if (start == -1) return "N/A";
        start += search.length();
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }
}
