package _06_inheritance.excercise;

public class CircleCylinderTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3.0, "Red");
        circle1.getArea();
        System.out.println("Area of circle is: " + circle1.getArea() + circle1.toString());
        Cylinder cylinder1 = new Cylinder(5.0, "Yellow", 5);
        System.out.println("Volume of circle is: " + cylinder1.getVolume() + cylinder1.toString());
        System.out.println("Area of circle is: " + cylinder1.getArea());
    }

}
