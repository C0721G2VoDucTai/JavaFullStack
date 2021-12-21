package _19_string_and_regex.exercise.validate_telephone_number;

public class TelephoneNumberTest {
    static TelephoneNumber telephoneNumber;
    private static final String[] numberTest = {"(84)-(0918826320)", "84-0918oi6320", "(84)-(0918834520)",
            "(85)-01234568", "8-0918874325", "(14)-(1973245681)", "32-07628345325"};
    public static void main(String[] args) {
        telephoneNumber = new TelephoneNumber();
        for (String validate : numberTest) {
            boolean isValidate = telephoneNumber.validateCheck(validate);
            System.out.println("Number phone: " + validate + " is " + isValidate);
        }
    }
}