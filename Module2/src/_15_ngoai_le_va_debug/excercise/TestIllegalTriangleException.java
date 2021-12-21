package _15_ngoai_le_va_debug.excercise;

import java.util.Scanner;

public class TestIllegalTriangleException {
    public static void checkSideTriangle(double side1, double side2, double side3) throws IllegalRightTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalRightTriangleException("Side is not a positive");
        }
        if (side1 + side2 <= side3 || side2 + side3 <= side1 || side1 + side3 < side2) {
            throw new IllegalRightTriangleException("sum of 2 sides must be greater than the other side");
        }
    }

    public static void main(String[] args) throws IllegalRightTriangleException {
        boolean flag;
        do {
           flag = false;
            Scanner scanner = new Scanner(System.in);
            double side1;
            System.out.println("Enter side 1: ");
            side1 = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter side 2: ");
            double side2 = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter side 3: ");
            double side3 = Double.parseDouble(scanner.nextLine());
            try {
                checkSideTriangle(side1, side2, side3);
                System.out.println("3 side of triangle is: " + side1 + ", " + side2 + ", " + side3);
            } catch (IllegalRightTriangleException a) {
                System.out.println(a.getMessage());
                flag = true;
            }
        } while (flag);

    }
}
