package _02_loop_conditions.practice;
import java.util.Scanner;
public class FindGreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        int b;
        System.out.println("Enter a");
        a = input.nextInt();
        System.out.println("Enter b");
        b = input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == b && b == 0) {
            System.out.println("No greatest common factor");
        } else {
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.println("Greatest common factor: " + a);

        }

    }
}
