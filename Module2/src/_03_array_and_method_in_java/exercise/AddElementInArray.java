package _03_array_and_method_in_java.exercise;

import java.util.Scanner;
import java.util.Arrays;

public class AddElementInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberArray[] = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
        int numberArray1[] = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0, 0};
        int x;
        int index;
        System.out.print("Enter x element: ");
        x = input.nextInt();
        System.out.print("Enter position x element: ");
        index = input.nextInt();
        if (x < 0 && x > numberArray1.length) {
            System.out.print("Cant add element: ");
        } else {
            for (int i = numberArray1.length - 1; i >= index; i--) {
                if (i != index) {
                    numberArray1[i] = numberArray1[i - 1];
                } else {
                    numberArray1[i] = x;
                }
            }
            System.out.println(Arrays.toString(numberArray1));
        }
    }
}