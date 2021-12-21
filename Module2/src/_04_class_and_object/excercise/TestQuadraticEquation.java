package _04_class_and_object.excercise;

import java.util.Scanner;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c;
        System.out.println("Enter a");
        a = input.nextDouble();
        System.out.println("Enter b");
        b = input.nextDouble();
        System.out.println("Enter c");
        c = input.nextDouble();
        BuildingQuadraticEquationClass quadraticEquation = new BuildingQuadraticEquationClass(a, b, c);
        if (quadraticEquation.getDelta() > 0) {
            System.out.println("Quadratic Equation have 2 root");
            System.out.println("Root1: " + quadraticEquation.getRoot1() + "," + "Root2: " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDelta() == 0) {
            System.out.println("Quadratic Equation have 1 root");
            System.out.println("Root1: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
