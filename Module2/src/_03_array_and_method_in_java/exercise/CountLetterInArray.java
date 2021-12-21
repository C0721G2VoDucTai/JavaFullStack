package _03_array_and_method_in_java.exercise;

import java.util.Scanner;
public class CountLetterInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = "Java full stack";
        String c ;
        System.out.println("Enter a letter: ");
        c = input.nextLine();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == c.charAt(0))
            count++;
           }
        System.out.println(count);
        }
    }

