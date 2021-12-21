package _05_access_modifier_static_method.practice;

public class TestStaticProperty {
    public static void main(String[] args) {
        StaticPropertyCar car1 = new StaticPropertyCar("Mazda 3","Skyactiv 3");
        System.out.println(StaticPropertyCar.numberOfCars);
        StaticPropertyCar car2 = new StaticPropertyCar("Mazda 6","Skyactiv 6");
        System.out.println(StaticPropertyCar.numberOfCars);
    }
}
