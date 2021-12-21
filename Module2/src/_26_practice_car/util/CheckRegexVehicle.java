package _26_practice_car.util;

import java.util.Scanner;

public class CheckRegexVehicle {
    public static final String ID_REGEX = "^KH(VN|NN)-\\d{5}$";
    public static final String NAME_REGEX = "([A-Z][a-z]+\\s?)+";
    public static final String INT_REGEX = "[1-9][0-9]*";
    public static final String CHOICE_REGEX = "[1-9][0-9]*";
    public static final String DAY_REGEX = "\\d{1,2}/\\d{1,2}/\\d{4}";
    public static final String YEAR_RG = "\\d{4}";
    public static final String VANS_RG = "\\d{2}C-\\d{3}.\\d{2}";
    public static final String CAR_RG = "\\d{2}C-\\d{3}.\\d{2}";
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
        String ID_REGEX = "SV-[1-9]\\d{3}";
        boolean b = name.matches(ID_REGEX);
        return b;
    }
}
