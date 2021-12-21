package _01_introduction_to_java.pratice;

import java.util.Scanner; // Đọc dữ liệu đầu vào từ nguồn khác

public class UsingOperator {
    public static void main(String[] args) {
        int a = 2 < 3 ? 2 : 3;
        switch (a) {
            case 1:
                System.out.print("A");
                break;
            case 2:
                System.out.print("B");
            default:
                System.out.print("C");
        }
    }
}
