package _00_lecture_practice.compar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainTestSort1 {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(234, "Nguyen Van D", 5.0));
        studentList.add(new Student(324, "Nguyen Van A", 8.0));
        studentList.add(new Student(423, "Nguyen Van C", 9.0));
        studentList.add(new Student(111, "Nguyen Van A", 9.0));

        // A. Sap xep cac hoc vien theo ten, hoc vien nao ma cung ten thi sap xep theo diem
        // Comparable, Comparator: ca 2 deu lam duoc
//        Collections.sort(studentList);
//        System.out.println(studentList);

        // B. Menu (chi Comparator)
        // 1. Sap xep hoc vien theo ten
        // 2. Sap xep hoc vien theo diem
        int choose = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Sap xep hoc vien theo ten");
            System.out.println("2. Sap xep hoc vien theo diem");
            System.out.println("0. Ket thuc");
            choose = scanner.nextInt();

            if (choose == 1) {
                Collections.sort(studentList, new StudentSortName());
            } else if (choose == 2) {
                Collections.sort(studentList, new StudentSortGrade());
            }

            System.out.println(studentList);
        } while (choose != 0);
    }
}
