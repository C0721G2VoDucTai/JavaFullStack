package _00_testing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhập số vào mảng:");
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("");
            nums[i] = sc.nextInt();
        }
        System.out.println("Sum = " + maxSumArray(nums));
    }

    public static int maxSumArray(int[] nums) {
        int max = 0;
        int max_end = 0;
        for (int i = 0; i < nums.length; i++) {
            max_end = max_end + nums[i];
            if (max_end < 0) {
                max_end = 0;
            } else if (max < max_end) {
                max = max_end;
            }
        }
        return max;
    }
}