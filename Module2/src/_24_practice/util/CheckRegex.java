package _24_practice.util;

import java.util.Scanner;

public class CheckRegex {
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

    public static boolean checkNumberId(String name) throws WrongFormatException {
        String ID_REGEX = "";
        boolean b = name.matches(ID_REGEX);
        if (!b) {
            throw new WrongFormatException("Error wrong request format");
        }
        return b;
    }

    public boolean check(String string, String regex) {
        return string.matches(regex);
    }
}