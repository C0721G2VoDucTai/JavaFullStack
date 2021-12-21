package _07_abstract_class_and_interface.practice.animal_interfcae;

import _07_abstract_class_and_interface.practice.fruit_interface.InterfaceEdible;

public class InterfaceChicken extends Animal implements InterfaceEdible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
