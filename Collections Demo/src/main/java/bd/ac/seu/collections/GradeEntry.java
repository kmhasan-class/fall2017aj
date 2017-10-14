package bd.ac.seu.collections;

public class GradeEntry {
    private Course course;
    private Faculty faculty;
    private int semesterId;
    private Grade grade;

    public GradeEntry() {
    }

    public GradeEntry(Course course, Faculty faculty, int semesterId, Grade grade) {
        this.course = course;
        this.faculty = faculty;
        this.semesterId = semesterId;
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public Grade getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "GradeEntry{" +
                "course=" + course +
                ", faculty=" + faculty +
                ", semesterId=" + semesterId +
                ", grade=" + grade +
                '}';
    }
}
