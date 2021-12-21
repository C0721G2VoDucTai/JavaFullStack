package _14_thuat_toan_sap_xep.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void insertSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            // vòng 1 gán x cho số thứ 2
            x = array[i];
            System.out.println(x);
            pos = i;
            System.out.println(x);
            while (pos > 0 && x < array[pos - 1]) {
                //vòng 1 nếu số thứ 2 < số thứ nhất thì đổi chổ
                // các vòng còn lại sẽ đẩy giá trị thấp nhất ra trước và sắp tăng dần
                // xếp tới vị trí pos
                array[pos] = array[pos - 1]; // đổi chỗ
                System.out.println("swap value element at pos and post -1 is:" +
                        " " + pos + " with " + array[pos - 1]);
                pos--;
                System.out.println("value pos is: " + pos);
                //điều kiện đúng vào vòng while thì true
            }
            array[pos] = x;
            System.out.println("value element at pos is: " + x);
        }
    }
}
