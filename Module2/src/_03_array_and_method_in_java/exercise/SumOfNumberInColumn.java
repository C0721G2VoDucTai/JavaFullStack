package _03_array_and_method_in_java.exercise;

import java.util.Scanner;
import java.util.Arrays;

public class SumOfNumberInColumn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter row of array number");
        int row = input.nextInt();
        System.out.print("Enter column of array number");
        int col = input.nextInt();
        int number[][] = new int[row][col];
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter number at position: " + i + j + ", ");
                number[i][j] = input.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(number));
        int column;
        do {
            System.out.println("Enter column get sum");
            column = input.nextInt();
            if (column > col - 1 || column < 0) {
                System.out.println("Enter column get sum again");
            }
        } while (column > col - 1 || column < 0);
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum = sum + number[i][column];
        }
        System.out.print("Sum of number at column: " + column + "is: " + sum);
    }
}