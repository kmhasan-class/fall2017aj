package bd.ac.seu.collections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoMysqlImplementation implements StudentDao {
    private List<Student> studentList;

    @Override
    public List<Student> getAllStudents() {
        try {
            Connection connection = JdbcConnection.getConnection();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        try {
            Connection connection = JdbcConnection.getConnection();

            Statement statement = connection.createStatement();

            String query;
            query = "DELETE FROM registration WHERE studentId = " + studentId;
            statement.executeUpdate(query);
            query = "DELETE FROM grades WHERE studentId = " + studentId;
            statement.executeUpdate(query);
            query = "DELETE FROM student WHERE studentId = " + studentId;
            int x = statement.executeUpdate(query);

            if (x > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Student getStudent(int studentId) {
        Student student = null;

        try {
            Connection connection = JdbcConnection.getConnection();

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM student WHERE studentId = " + studentId;
            ResultSet resultSet = statement.executeQuery(query);
            studentList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("studentName");
                student = new Student(id, name);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
}
