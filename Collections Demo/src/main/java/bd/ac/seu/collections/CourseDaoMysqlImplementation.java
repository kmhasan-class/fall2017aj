package bd.ac.seu.collections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoMysqlImplementation implements CourseDao {
    List<Course> courseList;

    @Override
    public List<Course> getAllCourses() {
        try {
            Connection connection = JdbcConnection.getConnection();

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM course";
            ResultSet resultSet = statement.executeQuery(query);
            courseList = new ArrayList<>();

            while (resultSet.next()) {
                String courseCode = resultSet.getString("courseCode");
                String courseTitle = resultSet.getString("courseTitle");
                double creditHours = resultSet.getDouble("credits");
                Course course = new Course(courseCode, courseTitle, creditHours);
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }
}
