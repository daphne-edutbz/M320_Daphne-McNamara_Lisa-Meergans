package ch.tbz;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        AnimalList animals = new AnimalList();
        animals.add(new Animal("Dog", 10, 15));
        animals.add(new Animal("Cat", 5, 8));
        animals.add(new Animal("Bird", 2, 1));

        System.out.println("Original:");
        animals.print();

        // Sort by name (Comparable)
        Collections.sort(animals);
        System.out.println("\nSort by name:");
        animals.print();

        // Sort by weight (Comparator)
        Collections.sort(animals, new WeightComparator());
        System.out.println("\nSort by weight:");
        animals.print();

        System.out.println("\nMovable animals (movable interface):");
        for (Animal a : animals) {
            a.move();
        }

    }
}