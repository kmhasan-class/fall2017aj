package bd.ac.seu.ormdemo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    private String courseCode;
    private String courseTitle;
    private double creditHours;
    @ManyToMany
    @JoinTable(name = "Registration",
            joinColumns = {@JoinColumn(name = "courseCode")},
            inverseJoinColumns = {@JoinColumn(name = "studentId")})
    Set<Student> studentSet;

    public Course() {
        studentSet = new HashSet<>();
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public Course(String courseCode, String courseTitle, double creditHours) {
        this();
        this.setCourseCode(courseCode);
        this.setCourseTitle(courseTitle);
        this.setCreditHours(creditHours);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(double creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", creditHours=" + creditHours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return courseCode.equals(course.courseCode);
    }

    @Override
    public int hashCode() {
        return courseCode.hashCode();
    }
}
