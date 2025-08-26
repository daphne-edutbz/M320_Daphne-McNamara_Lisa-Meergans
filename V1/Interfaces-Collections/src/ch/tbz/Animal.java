package ch.tbz;

public class Animal implements Comparable<Animal>, Movable {
    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name); //sort from name
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", weight=" + weight + "]";
    }

    @Override
    public void move() {
        System.out.println(name + " is moving.");
    }

    //getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



}
