package _13_thuat_toan_tim_kiem.exercise.optional;

import java.util.LinkedList;
import java.util.Scanner;

public class FindContinueStringMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String");
        String string = scanner.nextLine();
        LinkedList< Character > max = new LinkedList<>();
        for(int i=0; i<string.length(); i++) {
            LinkedList< Character > listTemp = new LinkedList<>();
            listTemp.push(string.charAt(i));
            int asc2 = listTemp.getLast();
            for (int j = i + 1; j < string.length(); j++) {
                int asc1 = string.charAt(j);
                if (asc1 - asc2 == 1) {
                    listTemp.push(string.charAt(j));
                    asc2++;

                }
            }
                if (listTemp.size() > max.size()) {
                    max.clear();
                    max.addAll(listTemp);
                }
            listTemp.clear();
        }
        String newString = "";
        for(int i=max.size()-1; i>=0; i--){
            newString+= max.get(i);
        }
        System.out.println(newString);

    }
}
