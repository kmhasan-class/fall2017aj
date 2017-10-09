package bd.ac.seu.collections;

import jdk.nashorn.internal.scripts.JD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class that drives the demonstrations.
 *
 * @author Monirul Hasan
 * @version 1.0-SNAPSHOT
 */
public class Main {
    private List<Student> studentList;

    public Main() {
//        StudentDao studentDao = new StudentDaoMysqlImplementation();
        StudentDao studentDao = new StudentDaoCsvImplementation();
        studentList = studentDao.getAllStudents();
/*
// From JDK1.1+
            for (int i = 0; i < studentList.size(); i++)
                System.out.println(studentList.get(i));
*/
/*
// From JDK1.5+
            for (Student student : studentList)
                System.out.println(student);
*/

// From JDK1.8+
            studentList.forEach(System.out::println);

/*
    Homework:
    1. Find out the student with the longest name
    2. Read course data from the database and save them into a list of courses
    3. Add a list of grades for each student and populate the student object with their own grades
 */
/*
// Finding the student with the longest name
            Student maxLengthNameStudent = studentList.get(0);
            for (Student student : studentList) {
                if (student.getStudentName().length() > maxLengthNameStudent.getStudentName().length()) {
                    maxLengthNameStudent = student;
                }
            }
            System.out.println("Maximum length of a name belongs to: " + maxLengthNameStudent);
            */
    }

    public static void main(String args[]) {
        new Main();
    }
}
