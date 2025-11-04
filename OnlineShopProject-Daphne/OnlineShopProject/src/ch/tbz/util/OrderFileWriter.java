package ch.tbz.util;

import ch.tbz.model.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderFileWriter {

    private static final String FILE_PATH = "src/ch/tbz/util/orders.txt";

    public static void saveOrdersToFile(List<Order> orders) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // append mode
            for (Order order : orders) {
                writer.write(order.toString() + "\n");
            }
            System.out.println("Orders saved to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error writing orders to file: " + e.getMessage());
        }
    }
}
