package ch.tbz;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<iBuyable> shoppingCart = new ArrayList<>();

        shoppingCart.add(new Milk(1.5));
        shoppingCart.add(new Banana(0.8));

        double total = 0;
        System.out.println("Quittung: ");
        int count = 1;
        for (iBuyable item : shoppingCart) {
            System.out.println("Artikel " + count + ": " + item.getClass().getSimpleName()
                    + " - " + item.price() + " CHF");
            total += item.price();
            count++;
        }
        System.out.printf("\nTotal: %.2f CHF\n", total);



    }
}