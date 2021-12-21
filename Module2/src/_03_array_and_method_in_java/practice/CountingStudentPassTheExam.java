package _03_array_and_method_in_java.practice;
import java.util.Scanner;
import java.util.Arrays;

public class CountingStudentPassTheExam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Enter number of Student: ");
        number = input.nextInt();
        float studentScore [] = new float[number];
        float score;
        int count = 0;
        for (int i = 0; i<number; i++) {
            do {
                System.out.print("Enter Student's score at position: " + (i + 1)+ " ");
                studentScore[i] = input.nextFloat();
                if(studentScore[i]>10 || studentScore[i]<0){
                    System.out.println("Please Enter again");
                }
            } while(studentScore[i] >10 ||studentScore[i]<0);
        }
        System.out.println("List of student's score: ");
        System.out.println(Arrays.toString(studentScore));
        System.out.print("Number of students have passed the exam is: ");
        for (int i = 0; i<number; i++) {
           if(studentScore[i] >=5) {
               count++;
           }
        }
        System.out.print(count);
        }
    }
