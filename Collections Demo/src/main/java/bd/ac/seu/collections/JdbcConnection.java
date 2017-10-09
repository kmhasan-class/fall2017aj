package bd.ac.seu.collections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class for getting a database connetion.
 */

// Reference to read when you go back home:
// Head First Design Patterns
/*
October 9, 2017
HW1: Read up Singleton design pattern
HW2: Look at different ways of creating Singletons in Java (Joshua Bloch's Effective Java)
 */
public class JdbcConnection {
    private static JdbcConnection instance = new JdbcConnection();
    private static Connection connection;

    private JdbcConnection() {
        connection = null;
        try {
//            System.out.println("We're in the private constructor");
            Class.forName("com.mysql.jdbc.Driver");

            final String DBURL = "jdbc:mysql://172.17.0.119/predictdb";
            final String USERNAME = "fall2017aj";
            final String PASSWORD = "aj";

            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
//        System.out.println("Get connection got called");
        return connection;
    }
}
