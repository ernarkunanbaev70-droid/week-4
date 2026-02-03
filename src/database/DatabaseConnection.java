package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/Shop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "8090donsomm";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("DB CONNECTED");
            return con;
        } catch (Exception e) {
            System.out.println("DB CONNECTION FAILED");
            return null;
        }
    }
}
