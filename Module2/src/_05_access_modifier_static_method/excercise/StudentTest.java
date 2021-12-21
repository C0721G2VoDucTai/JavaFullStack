package _05_access_modifier_static_method.excercise;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Billy");
        student.setClasses("C03");
        System.out.println(student.toString());
    }
}
