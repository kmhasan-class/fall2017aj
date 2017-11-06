package bd.ac.seu.aj.streamlabtask.repository;

import bd.ac.seu.aj.streamlabtask.model.Sex;
import bd.ac.seu.aj.streamlabtask.model.Student;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final List<Student> STUDENT_LIST = new ArrayList<>();

    static {
        createRandomStudents(10000);
    }

    private static void createRandomStudents(int studentCount) {
        NameGenerator generator = new NameGenerator();
        List<Name> names = generator.generateNames(studentCount);

        names.forEach(name ->
                STUDENT_LIST.add(new Student(STUDENT_LIST.size() + 1,
                        name.getFirstName() + " " + name.getLastName(),
                        Sex.valueOf(name.getGender().toString()))));
    }

    public static List<Student> getStudentList() {
        return STUDENT_LIST;
    }
}
