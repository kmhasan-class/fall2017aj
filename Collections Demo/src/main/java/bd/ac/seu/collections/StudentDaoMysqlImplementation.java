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
}
