package _05_access_modifier_static_method.practice;

public class StaticMethodStudent {
    private int rollno;
    private String name;
    private static String college = "BBDIT";
    StaticMethodStudent (int r, String n) {
        rollno = r;
        name = n;
    }
    static void change() {
        college = "CODEGYM";
    }
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
