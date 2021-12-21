package _06_inheritance.excercise;

public class Circle {
    private double radius;
    private String color;
    private double area;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
        this.area = this.radius*this.radius*Math.PI;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.area = this.radius * this.radius * Math.PI;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color +
                ", area='" + area + '\'' +
                '}';
    }
}

