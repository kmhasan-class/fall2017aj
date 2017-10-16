package bd.ac.seu.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<GradeEntry> gradeEntryList;
    /**
     * Creates a student with no id and no name.
     */
    public Student() {
        gradeEntryList = new ArrayList<>();
    }

    /**
     * Creates a student object with a specified id and name
     *
     * @param studentId ID of the student
     * @param studentName Name of the student
     */
    public Student(int studentId, String studentName) {
        this();
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

    public List<GradeEntry> getGradeEntryList() {
        return gradeEntryList;
    }

    public  double getCgpa() {
        double sumGradePoints = 0.0;
        double sumCredits = 0.0;

        Map<Course, Grade> gradeMap = new HashMap<>();

        for (GradeEntry gradeEntry : gradeEntryList) {
            Course course = gradeEntry.getCourse();
            Grade grade = gradeMap.get(course);
            if (grade == null) {
                gradeMap.put(course, grade);
            } else {
                Grade newGrade = gradeEntry.getGrade();
                if (newGrade.getNumericGrade() > grade.getNumericGrade())
                    grade = newGrade;
                gradeMap.put(course, grade);
            }
            /*
            double credits = gradeEntry.getCourse().getCredits();
            double numericGrade = gradeEntry.getGrade().getNumericGrade();

            sumCredits = sumCredits + credits;
            sumGradePoints = sumGradePoints + credits * numericGrade;
            */
        }

        gradeMap.forEach((course, grade) -> {
            // do your computation
        });
        /*if (Math.abs(sumCredits - 0) < 0.001)
            return 0.0;
        else*/
        return sumGradePoints / sumCredits;
    }
    /*
    Lab task:
    add a method to return the CGPA of a student
     */
    public double getTermGpa(int semesterId) {
        double sumGradePoints = 0.0;
        double sumCredits = 0.0;

        for (GradeEntry gradeEntry : gradeEntryList)
            if (semesterId == gradeEntry.getSemesterId()) {
                double credits = gradeEntry.getCourse().getCredits();
                double numericGrade = gradeEntry.getGrade().getNumericGrade();

                sumCredits = sumCredits + credits;
                sumGradePoints = sumGradePoints + credits * numericGrade;
            }

        /*if (Math.abs(sumCredits - 0) < 0.001)
            return 0.0;
        else*/
            return sumGradePoints / sumCredits;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gradeEntryList=" + gradeEntryList +
                '}';
    }
}
