package ch.tbz;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AirportImporter {

    public static Map<String, String> loadAirportsFromFile(String filename) {
        Map<String, String> airports = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String code = parts[0].trim();
                    String name = parts[1].trim();
                    airports.put(code, name);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading File" + e.getMessage());
        }
        return airports;
    }
}

