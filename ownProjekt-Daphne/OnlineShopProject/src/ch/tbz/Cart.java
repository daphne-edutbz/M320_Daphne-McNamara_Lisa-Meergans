package ch.tbz;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getItems() {
        return items;
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            items.forEach(System.out::println);
        }
    }
}