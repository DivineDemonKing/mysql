package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_Url = "jdbc:mysql://localhost:3306/coolDatabase";
    private static final String DB_Username = "root";
    private static final String DB_Password = "123456";
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(DB_Url, DB_Username, DB_Password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
