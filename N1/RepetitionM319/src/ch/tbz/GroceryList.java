package ch.tbz;

import java.util.ArrayList;

public class GroceryList {

    ArrayList<Product> Products = new ArrayList<>();


    public void showProducts() {
        if (Products.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Product product : Products) {
                System.out.println("\n" + product);
            }
        }
    }

    public void addProduct(Product product) {
        Products.add(product);
    }

    public void removeProduct(String productName) {
        Product toRemove = null;

        for (Product product : Products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                toRemove = product;
                break;
            }
        }

        if (toRemove != null) {
            Products.remove(toRemove);
            System.out.println(productName + " has been removed");
        } else {
            System.out.println(productName + " not found");
        }
    }




}
