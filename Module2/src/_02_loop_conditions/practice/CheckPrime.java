package _02_loop_conditions.practice;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("Input a number that you want check");
        number = input.nextInt();
        boolean flag = true;
        if (number < 2) {
            flag = false;
        } else {
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag || number == 2) {
            System.out.println(number + " is a prime");
        } else {
            System.out.println(number + " Not is a prime");
        }
    }
}

