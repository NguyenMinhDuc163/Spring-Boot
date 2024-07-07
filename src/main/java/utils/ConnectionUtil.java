package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "NguyenDuc@163";

    public static Connection getConnection() {
        try {
            return java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
