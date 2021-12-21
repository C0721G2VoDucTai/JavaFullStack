package _19_string_and_regex.exercise.validate_telephone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneNumber {
    private static final String TELEPHONE_NUMBER = "^[(]\\d{2}[)][-][(][0]\\d{9}[)]$";
    TelephoneNumber() {
    }
    public boolean validateCheck (String regex) {
        Pattern pattern = Pattern.compile(TELEPHONE_NUMBER);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

//    public boolean validate(String regex) {
//        Pattern pattern = Pattern.compile(TELEPHONE_NUMBER);
//        Matcher matcher = pattern.matcher(regex);
//        return matcher.matches();
//    }
}
