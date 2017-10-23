package bd.ac.seu.ormdemo.model;

// JPA - Java Persistence API

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private String emailAddress;
    @ManyToMany
    @JoinTable(name = "Registration",
            joinColumns = {@JoinColumn(name = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "courseCode")})
    private Set<Course> courseSet;

    public Student() {
        courseSet = new HashSet<>();
    }

    public Student(int studentId, String studentName) {
        this();
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return studentId;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }
}
