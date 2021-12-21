package _25_practice2.main;

import _24_practice.management.CustomerManagement;
import _24_practice.management.ReceiptManagement;
import _25_practice2.management.Management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        Scanner scr = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("List of selection\n" +
                    "1. Display \n" +
                    "2. Add \n" +
                    "3. Delete \n" +
                    "4. Exit \n");
            try {
                System.out.println("Enter your selection");
                int selection = Integer.parseInt(scr.nextLine());
                switch (selection) {
                    case 1:
                        management.display();
                        break;
                    case 2:
                        management.add();
                        break;
                    case 3:
                        management.delete();
                        break;
                    case 4:
                        flag = false;
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

}
