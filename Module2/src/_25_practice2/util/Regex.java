package _25_practice2.util;

import java.util.Scanner;

public class Regex {
    public static String checkRegex(String string, String regex, String err) {
        boolean check = true;
        do {
            if (string.matches(regex)) {
                check = false;
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.println(err);
                string = sc.nextLine();
            }
        } while (check);
        return string;
    }
}
