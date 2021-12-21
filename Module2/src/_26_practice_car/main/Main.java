package _26_practice_car.main;

import _26_practice_car.service.ManagementVehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagementVehicle managementVehicle = new ManagementVehicle();
        Scanner scr = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("List of selection\n" +
                    "1. Add \n" +
                    "2. Display \n" +
                    "3. Delete \n" +
                    "4. Exit \n");
            try {
                System.out.println("Enter your selection");
                int selection = Integer.parseInt(scr.nextLine());
                switch (selection) {
                    case 1:
                        managementVehicle.add();
                        break;
                    case 2:
                        managementVehicle.display();
                        break;
                    case 3:
                        managementVehicle.delete();
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
