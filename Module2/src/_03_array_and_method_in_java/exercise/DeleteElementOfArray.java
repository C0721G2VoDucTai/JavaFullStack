package _03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class DeleteElementOfArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numberArray[] = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        int x;
        boolean check = true;
        System.out.print("Enter element you want to delete");
        x = input.nextInt();
        int index = 0;
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] == x) {
                check = true;
                index = i;
                for (int j = i; j < numberArray.length; j++) {
                    if (j < numberArray.length - 1) {
                        numberArray[j] = numberArray[j + 1];
                    } else {
                        numberArray[j] = 0;
                    }
                }
                i = index;
                break;
            } else {
                check = false;
            }
        }
        if (check) {
            for (int number : numberArray) {
                System.out.print(number + ",");
            }
        } else {
            System.out.print("The number you entered is not in the array");
        }
    }
}