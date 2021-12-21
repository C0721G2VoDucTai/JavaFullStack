package _05_access_modifier_static_method.practice;

public class TestStaticMethod {
    public static void main(String[] args) {
        StaticMethodStudent.change();
        StaticMethodStudent student1 = new StaticMethodStudent(111, "Hoàng");
        StaticMethodStudent student2 = new StaticMethodStudent(222, "Khánh");
        StaticMethodStudent student3 = new StaticMethodStudent(333, "Nam");
        student1.display();
        student2.display();
        student3.display();
    }

}
