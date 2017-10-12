package bd.ac.seu.collections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDaoMysqlImplementation implements RegistrationDao {
    private List<Registration> registrationList;

    @Override
    public List<Registration> getAllRegistrations() {
        registrationList = new ArrayList<>();

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM registration";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String courseCode = resultSet.getString("courseCode");
                String facultyInitials = resultSet.getString("facultyInitials");
                int semesterId = resultSet.getInt("semesterId");

                Registration registration = new Registration(studentId, courseCode, facultyInitials, semesterId);
                registrationList.add(registration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrationList;
    }
}
