package bd.ac.seu.collections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeRecordDaoMysqlImplementation implements GradeRecordDao {
    private List<GradeRecord> gradeRecordList;

    @Override
    public List<GradeRecord> getAllGradeRecords() {
        gradeRecordList = new ArrayList<>();

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM grades";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String courseCode = resultSet.getString("courseCode");
                String facultyInitials = resultSet.getString("facultyInitials");
                String grade = resultSet.getString("grade");
                int semesterId = resultSet.getInt("semesterId");

                GradeRecord gradeRecord = new GradeRecord(studentId, courseCode, facultyInitials, grade, semesterId);
                gradeRecordList.add(gradeRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeRecordList;
    }
}
