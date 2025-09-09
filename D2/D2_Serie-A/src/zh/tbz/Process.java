package zh.tbz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Process {
    Flight flight = new Flight(1223, new ArrayList<>(Arrays.asList(
            new Passenger("Alice"),
            new Passenger("Bob"),
            new Passenger("Charlie")
    )));
    Scanner sc = new Scanner(System.in);
    private Schedule schedule;


    public Process() {
        schedule = new Schedule();
        schedule.addFlight(flight);
    }

    public void start() {
        boolean running = true;
        while(running) {
            System.out.println("1. Show Flights ");
            System.out.println("2. Add Passenger to flight ");
            System.out.println("3. Show passengers of flight ");
            System.out.println("4. Search passenger in flight");
            System.out.println("5. remove Passenger from flight");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    schedule.printAllFLights();
                    break;
                case 2:
                    addPassenger();
                    break;

                case 3:
                    showPassengers();
                    break;

                case 4:
                    searchPassenger();
                    break;

                case 5:
                    removePassenger();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;

            }

        }
    }

    private void addPassenger() {
        System.out.print("Enter flight number: ");
        int flightNum = sc.nextInt();
        Flight flight = schedule.findFlight(flightNum);
        if (flight == null) {
            System.out.println("Flight not found.");
            return;
        }
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();
        flight.addPassenger(new Passenger(name));
        System.out.println("Passenger added.");
    }

    private void showPassengers() {
        System.out.print("Enter flight number: ");
        int flightNum = sc.nextInt();
        Flight flight = schedule.findFlight(flightNum);
        if (flight != null) {
            for(int i = 0; i < flight.getPassengers().size(); i++) {
                System.out.print("Name: " + flight.getPassengers().get(i).getName());
            }
        } else {
            System.out.println("Flight not found.");
        }
    }

    private void searchPassenger() {
        System.out.print("Enter flight number: ");
        int flightNum = sc.nextInt();
        Flight flight = schedule.findFlight(flightNum);
        if (flight != null) {
            System.out.print("Enter passenger name: ");
            String name = sc.nextLine();
            Passenger p = flight.findPassenger(name);
            if (p != null) {
                System.out.println("Passenger found: " + p);
            } else {
                System.out.println("Passenger not found.");
            }
        }
    }

    public void removePassenger() {
        System.out.print("Enter flight number: ");
        int flightNum = sc.nextInt();
        Flight flight = schedule.findFlight(flightNum);
        if (flight != null) {
            System.out.print("Enter passenger name: ");
            String name = sc.nextLine();
            Passenger passenger = flight.findPassenger(name);
            flight.removePassenger(passenger);
        }
    }
}
