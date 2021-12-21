package _12_java_collection_framework.exercise.using_pratice_arraylist_linkedlist;

import _00_lecture_practice.StudentManagement;

import java.util.Scanner;

public class MainProducts {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        ProductsManagement management = new ProductsManagement();
        boolean flag = true;
        while (flag) {
            System.out.println("List of selection\n" +
                    "1. Add \n" +
                    "2. Display \n" +
                    "3. Delete \n" +
                    "4. Edit \n" +
                    "5. Search \n" +
                    "6. Sort Up \n" +
                    "7 Sort Down \n" +
                    "8. Exit \n");
            System.out.println("Enter your selection");
            int selection = Integer.parseInt(scr.nextLine());
            switch (selection) {
                case 1:
                    management.add();
                    break;
                case 2:
                    management.showList();
                    break;
                case 3:
                    management.delete();
                    break;
                case 4:
                    management.edit();
                    break;
                case 5:
                    management.search();
                    break;
                case 6:
                    management.sortUp();
                    break;
                case 7:
                    management.sortDown();
                    break;
                case 8:
                    flag = false;
                    break;
            }
        }
    }
}

