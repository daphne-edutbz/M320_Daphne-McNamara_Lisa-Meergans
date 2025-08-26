package ch.tbz;

public class Room {

    //attributes
    private String roomName;
    private Heating heating;


    //constructor
    public Room(String roomName, Heating heating) {
        this.roomName = roomName;
        this.heating = heating;
    }


    //Getter and Setter
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Heating getHeating() {
        return heating;
    }

    public void setHeating(Heating heating) {
        this.heating = heating;
    }
}
