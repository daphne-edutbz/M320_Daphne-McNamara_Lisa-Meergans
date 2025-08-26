package ch.tbz;

import java.util.Comparator;

public class WeightComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        return Double.compare(animal1.getWeight(), animal2.getWeight());
    }

}
