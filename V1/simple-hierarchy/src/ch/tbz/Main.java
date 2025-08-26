package ch.tbz;


public class Main {
    public static void main(String[] args) {

        Animal dog = new Dog("Bella", 3);
        Animal cat = new Cat("Kedi", 10);
        Animal bird = new Bird("Zwitacheralla", 5);

        dog.showInfo();
        cat.showInfo();
        bird.showInfo();

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();

    }
}