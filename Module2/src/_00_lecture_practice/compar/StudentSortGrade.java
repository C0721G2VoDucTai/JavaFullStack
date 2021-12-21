package _00_lecture_practice.compar;

import java.util.Comparator;

public class StudentSortGrade implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.getGrade() - o2.getGrade());
    }
}
