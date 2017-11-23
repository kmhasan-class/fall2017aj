package bd.ac.seu.aj.midtermexam;

import java.sql.Connection;

public class ConnectionSingleton {
    private final static ConnectionSingleton INSTANCE = new ConnectionSingleton();
    private static Connection connection;

    private ConnectionSingleton() {
        // We need to add some code that returns a proper connection
        connection = null;
    }

    public static Connection getConnection() {
        return connection;
    }
}
