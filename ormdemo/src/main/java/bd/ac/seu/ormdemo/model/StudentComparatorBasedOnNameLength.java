package bd.ac.seu.ormdemo.model;

import java.util.Comparator;

public class StudentComparatorBasedOnNameLength implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int length1 = s1.getName().getFirstName().length() + s1.getName().getLastName().length();
        int length2 = s2.getName().getFirstName().length() + s2.getName().getLastName().length();

//        return length1 == length2 ?
//                s1.getName().getFirstName().compareTo(s2.getName().getFirstName()) :
//                length1 - length2;

        if (length1 < length2)
            return -1;
        else if (length1 > length2)
            return +1;
        else {
//            return s1.getName().getFirstName().compareTo(s2.getName().getFirstName());
            if (s1.getName().getFirstName().compareTo(s2.getName().getFirstName()) < 0)
                return -1;
            else if (s1.getName().getFirstName().compareTo(s2.getName().getFirstName()) > 0)
                return +1;
            else return 0;
        }
    }
}
