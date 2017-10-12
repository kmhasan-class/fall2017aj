package bd.ac.seu.collections;

import java.util.List;

public interface StudentDao {
    public List<Student> getAllStudents();
    public boolean deleteStudent(int studentId);
    public default Student getStudent(int studentId) {
        List<Student> studentList = getAllStudents();
        for (Student student : studentList) {
            if (student.getStudentId() == studentId)
                return student;
        }
        return null;
    }
}
