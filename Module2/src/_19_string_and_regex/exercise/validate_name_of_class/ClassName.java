package _19_string_and_regex.exercise.validate_name_of_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static final String NAME_REGEX = "^[CAP]\\d{4}[GHIKLM]$";
    public ClassName(){

    }
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
