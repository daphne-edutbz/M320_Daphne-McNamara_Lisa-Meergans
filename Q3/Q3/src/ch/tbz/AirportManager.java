package ch.tbz;

import java.util.Iterator;
import java.util.Map;

public class AirportManager {
    private Map<String, String> airports;

    public AirportManager(Map<String, String> airports) {
        this.airports = airports;
    }

    public void addAirport(String code, String name) {
        airports.put(code, name);
    }

    public String searchAirport(String code) {
        String result = airports.get(code);
        if (result != null) {
             String airport = ("Found: " + code + " -> " + result);
             return airport;
        } else {
            String notFound = ("No airport found with code: " + code);
            return notFound;
        }
    }

    public void removeAirport(String code) {
        if (airports.remove(code) != null) {
            System.out.println("Airport with code " + code + " removed.");
        } else {
            System.out.println("No airport found with code: " + code);
        }
    }

    public void sortAirportsAlphabetically() {
        airports.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println("Code: " + e.getKey() + " -> " + e.getValue()));
    }

    public void showAllAirports() {
        airports.forEach((k, v) -> System.out.println("Code: " + k + " -> " + v));
    }

    public void showWithIterator() {
        Iterator<Map.Entry<String, String>> it = airports.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("Code: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public String searchAirportWithIterator(String code) {
        Iterator<Map.Entry<String, String>> it = airports.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            if (entry.getKey().equalsIgnoreCase(code)) {
                return "Found (Iterator): " + entry.getKey() + " -> " + entry.getValue();
            }
        }
        return "No airport found with code: " + code;
    }

}
