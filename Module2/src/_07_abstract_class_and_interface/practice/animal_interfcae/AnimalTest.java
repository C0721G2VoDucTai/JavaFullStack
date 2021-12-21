package _07_abstract_class_and_interface.practice.animal_interfcae;

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
//        animals[1] = new Chicken();
        Chicken chicken = new Chicken();
        chicken.makeSound();

        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }

    }
}
