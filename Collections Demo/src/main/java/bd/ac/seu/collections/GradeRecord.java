package bd.ac.seu.collections;

public class GradeRecord {
    private int studentId;
    private String courseCode;
    private String facultyInitials;
    private String grade;
    private int semesterId;

    public GradeRecord() {
    }

    public GradeRecord(int studentId, String courseCode, String facultyInitials, String grade, int semesterId) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.facultyInitials = facultyInitials;
        this.grade = grade;
        this.semesterId = semesterId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getFacultyInitials() {
        return facultyInitials;
    }

    public String getGrade() {
        return grade;
    }

    public int getSemesterId() {
        return semesterId;
    }

    @Override
    public String toString() {
        return "GradeRecord{" +
                "studentId=" + studentId +
                ", courseCode='" + courseCode + '\'' +
                ", facultyInitials='" + facultyInitials + '\'' +
                ", grade='" + grade + '\'' +
                ", semesterId=" + semesterId +
                '}';
    }
}
