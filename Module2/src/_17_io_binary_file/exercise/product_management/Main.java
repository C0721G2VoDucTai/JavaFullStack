package _17_io_binary_file.exercise.product_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        System.out.println("List of choice: \n " +
                "1. Add  product \n" +
                "2. Display  product \n" +
                "3. Edit  product \n" +
                "4. Search  product \n" +
                "5. Exit");
        while (flag) {
            System.out.println("Enter choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    management.add();
                    break;
                case 2:
                    management.display();
                    break;
                case 3:
                    management.edit();
                    break;
                case 4:
                    management.search();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}
