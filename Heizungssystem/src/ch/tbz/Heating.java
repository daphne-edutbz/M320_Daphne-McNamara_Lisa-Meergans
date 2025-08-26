package ch.tbz;

public class Heating {

    //attributes
    private int temperature; //Datenkapselung -> attributes are private, not accessible from outside


    //constructor
    public Heating(int temperature) {
        this.temperature = temperature;
    }


    //Getter and Setter
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}