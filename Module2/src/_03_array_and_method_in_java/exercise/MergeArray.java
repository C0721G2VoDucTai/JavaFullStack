package _03_array_and_method_in_java.exercise;

import java.util.Scanner;
import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        String array1[] = {"Hà Nội", "Hải Phòng", "Nam Định"};
//        String array2[] = {"Huế", "Đà Nẵng"};
//        String array[] = new String[5];
        int a1, a2;
        System.out.println("Enter length of array1: ");
        a1 = input.nextInt();
        System.out.println("Enter length of array2: ");
        a2 = input.nextInt();
        int array1[] = new int[a1];
        int array2[] = new int[a2];
        for (int i = 0; i < a1; i++) {
            System.out.print("Enter Element of array1 at position: " + (i + 1) + " ");
            array1[i] = input.nextInt();
            input.nextLine();
        }
        for(int i=0; i<a2; i++) {
            System.out.print("Enter Element of array2 at position: " + (i+1));
            array2[i] = input.nextInt();
        }
        int array[] = new int[a1 + a2];
        for (int i = 0; i < array.length; i++) {
            if (i < array1.length) {
                array[i] = array1[i];
            } else {
                array[i] = array2[i - a1];
            }
        }
        System.out.print("Display array: ");
        System.out.print(Arrays.toString(array));
    }
}
