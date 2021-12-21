package _17_io_binary_file.practice.read_write_student_list;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);// làm sao xuống dòng
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
    public static void main(String[] args) {
            List<Student> students = new ArrayList<>();
            students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
            students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
            students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
            students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
            students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
            writeToFile("src\\_17_io_binary_file\\practice\\" +
                    "read_write_student_list\\student.txt", students);
           List<Student> list =  readDataFromFile("src\\_17_io_binary_file\\practice\\" +
                   "read_write_student_list\\student.txt");
           for(Student student : list) {
               System.out.println(student.toString());
        }
    }
}
