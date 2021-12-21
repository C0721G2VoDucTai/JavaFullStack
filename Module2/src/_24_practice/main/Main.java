package _24_practice.main;

import _24_practice.management.CustomerManagement;
import _24_practice.management.ReceiptManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerManagement customerManagement = new CustomerManagement();
        ReceiptManagement receiptManagement = new ReceiptManagement();
        Scanner scr = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("List of selection\n" +
                    "1. Add customer\n" +
                    "2. Display information of customer \n" +
                    "3. Search information of customer \n" +
                    "4. Add receipt \n" +
                    "5. Edit receipt  \n" +
                    "6. Display information of receipt \n" +
                    "7. Exit \n");
            try {
                System.out.println("Enter your selection");
                int selection = Integer.parseInt(scr.nextLine());
                switch (selection) {
                    case 1:
                        customerManagement.add();
                        break;
                    case 2:
                        customerManagement.display();

                        break;
                    case 3:
                        customerManagement.search();

                        break;
                    case 4:
                        receiptManagement.add();
                        break;
                    case 5:
                        receiptManagement.edit();
                        break;
                    case 6:
                        receiptManagement.display();
                        break;
                    case 7:
                        flag = false;
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
