package zh.tbz;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight findFlight(int flightNumber) {
        for (Flight flight : flights) {
            if(flight.getFlightNumber() == flightNumber){
                return flight;
            }
        }
        return null;
    }


    public void printAllFLights(){
        System.out.println("Schedule");
        for (Flight flight : flights) {
            System.out.println("- " + flight.getFlightNumber());
        }
    }

}
