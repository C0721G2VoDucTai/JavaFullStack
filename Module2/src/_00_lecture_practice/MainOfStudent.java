package _00_lecture_practice;

import java.util.Scanner;

public class MainOfStudent {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.data();
        boolean flag = true;
        while (flag) {
            System.out.println("List of selection\n" +
                    "1. Add \n" +
                    "2. Display \n" +
                    "3. Delete \n" +
                    "4. Edit \n" +
                    "5. Search \n" +
                    "6. Exit \n" );
            System.out.println("Enter your selection");
            int selection = Integer.parseInt(scr.nextLine());
            switch(selection) {
                case 1:
                    studentManagement.add();
                    break;
                case 2:
                    studentManagement.display();
                    break;
                case 3:
                    studentManagement.delete();
//                    studentManagement.display();
                    break;
                case 4:
                    studentManagement.edit();
                    break;
                case 5:
                    studentManagement.search();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }
    }
}
