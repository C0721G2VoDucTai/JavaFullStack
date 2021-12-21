package _examination.util;

import java.util.Scanner;

public class CheckRegex {
    public static final String ID_REGEX = "STK-\\d{6}";
    public static final String NAME_REGEX = "([A-Z][a-z]+\\s?)+";
    public static final String INT_REGEX = "[1-9][0-9]*";
    public static final String CHOICE_REGEX = "[1-9][0-9]*";
    public static final String CHOICE = "[12]";
    public static final String NGAN_HAN= "[3-6]\\sThang";
    public static final String DAI_HAN= "([0-9]|10)\\sNam";
    public static final String DAY_REGEX = "\\d{1,2}/\\d{1,2}/\\d{4}";
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
    public static boolean checkNumberId(String name) {
        String ID_REGEX = "";
        boolean b = name.matches(ID_REGEX)  ;
        return b;
    }
}
