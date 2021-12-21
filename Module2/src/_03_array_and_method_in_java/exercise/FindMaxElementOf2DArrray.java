package _03_array_and_method_in_java.exercise;
import java.util.Arrays;
import java.util.Scanner;

public class FindMaxElementOf2DArrray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row, col;
        System.out.print("Enter row number of array: ");
        row = Integer.parseInt(input.nextLine());
        System.out.print("Enter col number of array: ");
        col = Integer.parseInt(input.nextLine());
        int array[][] = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++){
                System.out.print("Enter element at position: " +i+j + " ");
                array[i][j] = Integer.parseInt(input.nextLine());
            }
        }
        System.out.println("Display array:");
        System.out.println(Arrays.deepToString(array));
        int max =array[0][0];
        int indexrow =0, indexcol =0;
        for(int i =0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(array[i][j] > max) {
                    max = array[i][j];
                    indexrow = i ;
                    indexcol = j ;
                }
            }
        }
        System.out.println("Max is: "+ max + " position is: "+ " row: " + indexrow + " col: " +indexcol);
    }
}
