package _04_class_and_object.excercise;

import java.util.Scanner;

public class BuildingQuadraticEquationClass {
    double a, b, c;

    public BuildingQuadraticEquationClass() {
    }

    public BuildingQuadraticEquationClass(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDelta() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        if (getDelta() >= 0) {
            return (this.b + Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / 2;

        } else {
            return 0;
        }
    }

    public double getRoot2() {
        if (getDelta() >= 0) {
            return (this.b - Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / 2;

        } else {
            return 0;
        }
    }
}
