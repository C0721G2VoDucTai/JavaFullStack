package _19_string_and_regex.exercise.validate_name_of_class;

public class ClassNameTest {
    private  static  ClassName className;
    private static final String [] validate = {"A1234H", "C0230G", "C0721G","P0213I" };
    private static final String [] unValidate = {"B1234H", "C230G", "C0721A","P0213Z" };

    public static void main(String[] args) {
        className = new ClassName();
        for(String string : validate) {
            boolean isValidate = className.validate(string);
            System.out.println("Email is " + string +" is valid: "+ isValidate);
        }
        for(String string : unValidate) {
            boolean isValidate = className.validate(string);
            System.out.println("Email is " + string +" is valid: "+ isValidate);
        }

    }
}
