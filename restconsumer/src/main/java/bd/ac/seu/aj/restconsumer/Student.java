package bd.ac.seu.aj.restconsumer;

public class Student {
    private String studentId;
    private String studentName;
    private double cgpa;

    public Student() {
    }

    public Student copy() {
        return new Student(studentId, studentName, cgpa);
    }

    public Student(String studentId, String studentName, double cgpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.cgpa = cgpa;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("studentId='").append(studentId).append('\'');
        sb.append(", studentName='").append(studentName).append('\'');
        sb.append(", cgpa=").append(cgpa);
        sb.append('}');
        return sb.toString();
    }
}
