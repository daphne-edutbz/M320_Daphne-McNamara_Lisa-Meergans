package ch.tbz;

import java.util.List;

public class House {

    //attributes
    private List<Room> rooms;


    //constructor
    public House(List<Room> rooms) {
        this.rooms = rooms;
    }


    //to regulate temperatures from a central place
    public void setAllTemperatures(int temperature) {
        for (Room room : rooms) {
            room.getHeating().setTemperature(temperature);
        }
    }

    //
    public void showStatus() {
        for (Room room : rooms) {
            System.out.println("Room: " + room.getRoomName() + "\n Temperature: " + room.getHeating().getTemperature());
        }
    }


    //Getter and Setter
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
