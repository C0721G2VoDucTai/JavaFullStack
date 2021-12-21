package _03_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinElementOfArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Enter length of array (n): ");
        n = Integer.parseInt(input.nextLine());
        int array[] = new int[n] ;
        for(int i=0; i<array.length; i++) {
            System.out.print("Enter element at position: " + i + " ");
            array[i] = Integer.parseInt(input.nextLine());
        }
        System.out.println("Display array: ");
        System.out.println(Arrays.toString(array));
        int min = array[0];
        int index = 0;
        for(int i=1; i<array.length; i++) {
            if(array[i] <min ){
                min = array[i];
                index = i;
            }
        }
        System.out.println("Min of array is: " + min  +" at position is: " + index);
    }
}
