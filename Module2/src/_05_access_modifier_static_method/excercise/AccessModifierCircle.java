package _05_access_modifier_static_method.excercise;

public class AccessModifierCircle {
    private double radius = 1.0;
    private String color = "Red";
    AccessModifierCircle(){}
    AccessModifierCircle(double radius){
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getArea() {
        return this.radius*this.radius*Math.PI;
    }
}
