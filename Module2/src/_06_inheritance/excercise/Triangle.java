package _06_inheritance.excercise;

import _06_inheritance.practice.Shape;


public class Triangle extends Shape {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea(double h) {
        return (side3 * h) / 2;
    }

    public double getPerimeter() {
        return this.side3 + this.side2 + this.side1;
    }

    public String getInformation(String color, double side1, double side2, double side3, double height) {
        super.setColor(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        double h = height;
        return "Triangle have side 1: " + this.side1 +
                " side 2: " + this.side2 +
                " side 2: " + this.side3 +
                " area: " + getArea(h) +
                " perimeter: " + getPerimeter() +
                " color: " + super.getColor();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}


