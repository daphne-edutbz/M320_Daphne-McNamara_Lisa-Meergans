package ch.tbz;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Heating
        Heating chillTemp = new Heating(18);
        Heating roomTemp = new Heating(21);
        Heating warmTemp = new Heating(28);

        //Rooms
        Room livingRoom = new Room("Living Room", warmTemp);
        Room bedRoom = new Room("Bed Room", roomTemp);
        Room bathroom = new Room("Bathroom", chillTemp);

        //put rooms in House
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(livingRoom);
        rooms.add(bedRoom);
        rooms.add(bathroom);

        House house = new House(rooms);

        System.out.println("Temperature Status: ");
        house.showStatus();

        System.out.println("\nRegulate all temperatures: 22°C");
        house.setAllTemperatures(22); //example of objects comunicationg with each other
        System.out.println("Temperature Status: ");
        house.showStatus();

        //change temperature
        System.out.println("\n change Temperature of Bedroom: 18°C");
        bedRoom.getHeating().setTemperature(18); //example of the state of an object changing
        System.out.println("Temperature Status: ");
        house.showStatus();
    }
}
