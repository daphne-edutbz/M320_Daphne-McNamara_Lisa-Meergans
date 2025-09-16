package zh.tbz;

public interface Rentable {
    String getName();
    boolean isAvailable();
    void rent();
    void returnVehicle();
}
