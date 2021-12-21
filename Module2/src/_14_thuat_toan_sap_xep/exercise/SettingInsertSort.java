package _14_thuat_toan_sap_xep.exercise;

import java.util.Scanner;

public class SettingInsertSort {
    public static void insertSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            System.out.println(x);
            pos = i;
            System.out.println(x);
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                System.out.println("swap value element at pos and post -1 is:" +
                        " " + pos + " with " + array[pos - 1]);
                pos--;
                System.out.println("value pos is: " + pos);
                array[pos] = x;
                System.out.println("value element at pos is: " + x);
            }
        }
    }

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
    }
}

