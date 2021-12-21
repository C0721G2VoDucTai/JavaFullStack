package _05_access_modifier_static_method.excercise;

import _05_access_modifier_static_method.excercise.AccessModifierCircle;

public class TestCircle {
    public static void main(String[] args) {
        AccessModifierCircle circle1 = new AccessModifierCircle(3.0);
        System.out.println("Radius of circle1 is: " + circle1.getRadius());
        System.out.println("Area of circle1 is: " +circle1.getArea());

    }
}
