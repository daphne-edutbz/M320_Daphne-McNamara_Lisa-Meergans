package zh.tbz;

import java.util.List;
import java.util.ArrayList ;

public class Main {
    public static void main(String[] args) {
        List<iBuyable> shoppingCart = new ArrayList<>();

        shoppingCart.add(new Milk(1.50));
        shoppingCart.add(new Banana(0.70));
        shoppingCart.add(new Banana(0.65));

        // Quittung ausgeben
        double total = 0;
        System.out.println("Quittung:");
        for (iBuyable item : shoppingCart) {
            System.out.println(item.name() + " - " + item.price() + " CHF");
            total += item.price();
        }

        System.out.println("-------------------");
        System.out.println("Total: " + total + " CHF");
    }
}