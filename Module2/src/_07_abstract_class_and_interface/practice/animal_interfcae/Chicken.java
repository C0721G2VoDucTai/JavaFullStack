package _07_abstract_class_and_interface.practice.animal_interfcae;

import _07_abstract_class_and_interface.practice.animal_interfcae.Animal;

public class Chicken extends Animal {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
}
