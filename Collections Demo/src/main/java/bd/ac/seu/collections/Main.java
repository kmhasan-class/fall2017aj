package bd.ac.seu.collections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class that drives the demonstrations.
 *
 * @author Monirul Hasan
 * @version 0.0.1-SNAPSHOT
 */
public class Main {
    private List<Student> studentList;

    public Main() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            final String DBURL = "jdbc:mysql://172.17.0.119/predictdb";
            final String USERNAME = "fall2017aj";
            final String PASSWORD = "aj";

            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(query);
            studentList = new ArrayList<>();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("studentName");
                Student student = new Student(studentId, studentName);
                studentList.add(student);
            }
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Main();
    }
}
