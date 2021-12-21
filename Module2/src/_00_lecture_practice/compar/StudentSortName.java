package _00_lecture_practice.compar;

import java.util.Comparator;

public class StudentSortName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
//        if (o1.getName().compareTo(o2.getName()) > 0) {
//            return -1;
//        } else if (o1.getName().compareTo(o2.getName()) == 0) {
//            return 0;
//        } else {
//            return 1;
//        }
        return o1.getName().compareTo(o2.getName());
    }
}
