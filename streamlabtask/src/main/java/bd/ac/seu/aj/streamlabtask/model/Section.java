package bd.ac.seu.aj.streamlabtask.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private Course course;
    private Semester semester;
    private Faculty faculty;
    private int sectionNumber;
    private List<Student> studentList;

    public Section() {
        studentList = new ArrayList<>();
    }

    public Section(Course course, int sectionNumber, Semester semester, Faculty faculty) {
        this();
        this.course = course;
        this.sectionNumber = sectionNumber;
        this.semester = semester;
        this.faculty = faculty;
    }


    public Course getCourse() {
        return course;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public Semester getSemester() {
        return semester;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Section{");
        sb.append("course=").append(course);
        sb.append(", semester=").append(semester);
        sb.append(", faculty=").append(faculty);
        sb.append(", sectionNumber=").append(sectionNumber);
        sb.append(", studentList=").append(studentList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        if (sectionNumber != section.sectionNumber) return false;
        if (!course.equals(section.course)) return false;
        return semester.equals(section.semester);
    }

    @Override
    public int hashCode() {
        int result = course.hashCode();
        result = 31 * result + semester.hashCode();
        result = 31 * result + sectionNumber;
        return result;
    }
}
