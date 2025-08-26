package ch.tbz;

import java.util.ArrayList;

public class AnimalList extends ArrayList<Animal> {
    public void print() {
        for (Animal a : this) {
            System.out.println(a);
        }
    }

}
