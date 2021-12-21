package _00_lecture_practice;

import java.util.Scanner;

public class StudentManagement {
    private  static OopStudent[] studentList = new OopStudent[100];
    static int length = 4;

    // dua ra ham rieng goi khi ct main chay
    public void data() {
        studentList[0] = new OopStudent("Nam", 21, "Đà Nẵng");
        studentList[1] = new OopStudent("Hai", 22, "Đà Nẵng");
        studentList[2] = new OopStudent("Chi", 21, "Đà Nẵng");
        studentList[3] = new OopStudent("Nam", 22, "Quảng Nam");
    }

    public void add() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scr.nextLine();
        System.out.println("Enter age: ");
        int age = Integer.parseInt(scr.nextLine());
        System.out.println("Enter address: ");
        String address = scr.nextLine();
        OopStudent student = new OopStudent(name, age, address);
        for (int i = 0; i <= length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                length++;
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i <= length; i++) {
            if (studentList[i] != null) {
                System.out.println(studentList[i].toString());
            } else {
                continue;
            }
        }
    }

    public void edit() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter edit name: ");
        String editName = scr.nextLine();
        for (int i = 0; i <= length; i++) {
            if (studentList[i] != null) {
                if (studentList[i].getName().equals(editName)) {
                    System.out.println("STT" + i + " " + studentList[i].toString());
                    System.out.println("Enter name: ");
                    String name = scr.nextLine();
                    studentList[i].setName(name);
                    System.out.println("Enter age: ");
                    int age = Integer.parseInt(scr.nextLine());
                    studentList[i].setAge(age);
                    System.out.println("Enter address: ");
                    String address = scr.nextLine();
                    studentList[i].setAddress(address);
                }
            }
            else{
                continue;
            }
        }
    }

    public void delete() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter delete name: ");
        String deleteName = scr.nextLine();
        for (int i = 0; i <= length; i++) {
            if (studentList[i] != null) {
                if (studentList[i].getName().equals(deleteName)) {
                    studentList[i] = null;
//                    studentList[i] = studentList[i +1];
//                    length--;
                }
            } else {
                continue;
            }
        }
    }

    public void search() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter search name: ");
        String searchName = scr.nextLine();
        int index;
        for (int i = 0; i <= length; i++) {
            if (studentList[i] != null) {
                if (studentList[i].getName().equals(searchName)) {
                    index = i;
                    System.out.println(studentList[i].toString() + " position: " + index);
                }
            } else {
                continue;
            }
        }
    }
}