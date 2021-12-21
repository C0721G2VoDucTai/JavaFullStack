package _03_array_and_method_in_java.practice;

import java.util.Scanner;

public class FindAValueInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String student[] = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        String name;
        System.out.println("Enter the name of the student you wanna find : ");
        name = input.nextLine();
        boolean isExist = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(name)) {
                System.out.println("Position of student " + name + "is " + i + " in list");
                isExist = true;
                break;
            }
        }
        if (isExist == false)
        {
            System.out.println("Not found" + name + " in the list.");
        }
    }
}
