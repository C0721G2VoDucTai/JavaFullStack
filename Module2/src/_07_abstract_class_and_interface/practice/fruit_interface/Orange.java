package _07_abstract_class_and_interface.practice.fruit_interface;

import _07_abstract_class_and_interface.practice.fruit_interface.Fruit;

public class Orange extends Fruit {
    @Override
    public String howToEat() {
        return "Orange could be juiced";
    }
}
