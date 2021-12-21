package _02_loop_conditions.excercise;

import java.util.Scanner;

public class DispayGeometry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1: Print the rectangle");
        System.out.println("2: Print the square triangle (The corner is square at 4 different angles)");
        System.out.println("3: Print isosceles triangle");
        System.out.println("4: Exit");
        int choice;
        System.out.println("Enter your choice");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 8; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < i + 1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for (int i = 0; i < 5; i++) {
                    for (int j =0; j<5-i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5 - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < i + 1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < i+1; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < 5-i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5 - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j <2*i+1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 4:
                break;
        }
    }
}
