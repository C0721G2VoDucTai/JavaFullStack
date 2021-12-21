package _03_array_and_method_in_java.exercise;
import java.util.Scanner;
import java.util.Arrays;
public class SumOfDiagonalsOfASquareMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row;
        System.out.println("Enter row number: ");
        row = Integer.parseInt(input.nextLine());
//        System.out.println("Enter row number: ");
//        col = Integer.parseInt(input.nextLine());
        int number [][] = new int[row][row];
        for (int i=0; i<row; i++) {
            for(int j=0; j<row; j++){
                System.out.print("Enter element: " + i+""+j);
                number[i][j] = Integer.parseInt(input.nextLine());
            }
        }
        System.out.println("Display number array");
        System.out.println(Arrays.deepToString(number));
        int sum = 0;
        for(int i=0; i<number.length; i++) {
                sum = sum + number[i][i] + number[i][number.length-1 - i];
        }
        System.out.print("Sum is: " + sum);
    }
}
