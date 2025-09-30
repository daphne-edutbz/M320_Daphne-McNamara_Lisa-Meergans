package ch.tbz;

import java.util.Map;
import java.util.Scanner;

public class AirportApp {

    public void run() {
        Map<String, String> airportData = AirportImporter.loadAirportsFromFile("airports.csv");
        AirportManager manager = new AirportManager(airportData);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Airport Manager ---");
            System.out.println("[1]search | [2]search (Iterator) | [3]add | [4]remove | [5]list | [6]list (Iterator) | [7]sort | [0]quit");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.print("Enter code: ");
                    String code = scanner.nextLine();
                    System.out.println(manager.searchAirport(code));
                    break;
                case "2":
                    System.out.print("Enter code: ");
                    String codeIter = scanner.nextLine();
                    System.out.println(manager.searchAirportWithIterator(codeIter));
                    break;
                case "3":
                    System.out.print("Enter code: ");
                    String newCode = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String newName = scanner.nextLine();
                    manager.addAirport(newCode, newName);
                    break;
                case "4":
                    System.out.print("Enter code to remove: ");
                    String removeCode = scanner.nextLine();
                    manager.removeAirport(removeCode);
                    break;
                case "5":
                    System.out.println("Airports:");
                    manager.showAllAirports();
                    break;
                case "6":
                    System.out.println("Airports (Iterator):");
                    manager.showWithIterator();
                    break;
                case "7":
                    System.out.println("Airports sorted alphabetically:");
                    manager.sortAirportsAlphabetically();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }

        scanner.close();
    }
}
