package _02_loop_conditions.excercise;

import java.util.Scanner;

public class DisplayPrimeNumberLessThan100 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte count = 1;
        int n = 3;
        System.out.print(2 + " ");
        while (n < 100) {
            boolean check = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(n + " ");
            }
            n++;
        }
    }
}
