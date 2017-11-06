package bd.ac.seu.aj.streamlabtask.model;

import bd.ac.seu.aj.streamlabtask.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String name;
    private Sex sex;
    private List<Pair<Section, Grade>> gradeList;

    public Student() {
        gradeList = new ArrayList<>();
    }

    public Student(int studentId, String name, Sex sex) {
        this();
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Pair<Section, Grade>> getGradeList() {
        return gradeList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("studentId=").append(studentId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", gradeList=").append(gradeList);
        sb.append('}');
        return sb.toString();
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
}
