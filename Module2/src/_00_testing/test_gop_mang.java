package _00_testing;

import java.util.Arrays;
import java.util.Scanner;

public class test_gop_mang {
    public static void main(String[] args) {
        int array[] = {1, 0, -3, 5, -1, -3, 8};
        for (int i = 0; i <= array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

//        Scanner input = new Scanner(System.in);
////        String array1[] = {"Hà Nội", "Hải Phòng", "Nam Định"};
////        String array2[] = {"Huế", "Đà Nẵng"};
////        String array[] = new String[5];
//        int a1, a2;
//        System.out.println("Enter length of array1: ");
//        a1 = Integer.parseInt(input.nextLine());
//        System.out.println("Enter length of array2: ");
//        a2 = Integer.parseInt(input.nextLine());
//        String array1[] = new String[a1];
//        String array2[] = new String[a2];
//        for (int i = 0; i < a1; i++) {
//            System.out.print("Enter Element of array1 at position: " + (i + 1) + " ");
//            array1[i] = input.nextLine();
//        }
//        for(int i=0; i<a2; i++) {
//            System.out.print("Enter Element of array2 at position: " + (i+1));
//            array2[i] = input.nextLine();
//        }
//        String array[] = new String[a1 + a2];
//        for (int i = 0; i < array.length; i++) {
//            if (i < array1.length) {
//                array[i] = array1[i];
//            } else {
//                array[i] = array2[i - a1];
//            }
//        }
//        System.out.print("Display array: ");
//        System.out.print(Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }
}
