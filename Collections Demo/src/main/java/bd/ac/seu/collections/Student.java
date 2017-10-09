package bd.ac.seu.collections;

/**
 * Model class to represent Student data type.
 *
 * For each student we retain their student ID and name.
 * @author Monirul Hasan
 * @version 1.0-SNAPSHOT
 */
public class Student {
    private int studentId;
    private String studentName;

    /**
     * Creates a student with no id and no name.
     */
    public Student() {
    }

    /**
     * Creates a student object with a specified id and name
     *
     * @param studentId ID of the student
     * @param studentName Name of the student
     */
    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
