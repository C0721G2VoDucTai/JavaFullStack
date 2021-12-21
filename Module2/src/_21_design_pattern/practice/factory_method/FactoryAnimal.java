package _21_design_pattern.practice.factory_method;

public class FactoryAnimal {
    public Animal getAnimal(String type) {
        if ("canine".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
