package zh.tbz;

import java.util.List;
import java.util.ArrayList ;

public class Main {
    public static void main(String[] args) {
        List<iBuyable> shoppingCart = new ArrayList<>();

        shoppingCart.add(new Milk("Milk", 2.99));
        shoppingCart.add(new Banana("Banana", 1.99));

        // receipt
        double total = 0;
        System.out.println("Receipt:");
        for (iBuyable item : shoppingCart) {
            System.out.println(item.name() + " - " + item.price() + " CHF");
            total += item.price();
        }

        System.out.println("-------------------");
        System.out.println("Total: " + total + " CHF");
    }
}