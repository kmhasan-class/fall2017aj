package bd.ac.seu.ormdemo.model;

import java.util.Comparator;

public class StudentComparatorBasedOnEmailAddress implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        //return s1.getEmailAddress().compareTo(s2.getEmailAddress());

        if (s1.getEmailAddress().compareTo(s2.getEmailAddress()) < 0)
            return -1;
        else if (s1.getEmailAddress().compareTo(s2.getEmailAddress()) > 0)
            return +1;
        else return 0;
    }
}
