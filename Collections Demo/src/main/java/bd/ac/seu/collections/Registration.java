package bd.ac.seu.collections;

public class Registration {
    private int studentId;
    private String courseCode;
    private String facultyInitials;
    private int semesterId;

    public Registration() {
    }

    public Registration(int studentId, String courseCode, String facultyInitials, int semesterId) {
        this.setStudentId(studentId);
        this.setCourseCode(courseCode);
        this.setFacultyInitials(facultyInitials);
        this.setSemesterId(semesterId);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFacultyInitials() {
        return facultyInitials;
    }

    public void setFacultyInitials(String facultyInitials) {
        this.facultyInitials = facultyInitials;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "studentId=" + studentId +
                ", courseCode='" + courseCode + '\'' +
                ", facultyInitials='" + facultyInitials + '\'' +
                ", semesterId=" + semesterId +
                '}';
    }
}
