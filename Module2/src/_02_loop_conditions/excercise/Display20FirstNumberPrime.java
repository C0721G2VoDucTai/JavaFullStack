package _02_loop_conditions.excercise;

public class Display20FirstNumberPrime {
    public static void main(String[] args) {
        byte count = 1;
        int n = 3;
        System.out.print(2 + " ");
        while (count < 20) {
            boolean check = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }
}


