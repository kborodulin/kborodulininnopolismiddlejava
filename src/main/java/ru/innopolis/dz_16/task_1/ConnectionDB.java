package ru.innopolis.dz_16.task_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection connectDB() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/dz_15";
        String user = "postgres";
        String password = "postgres";
        return DriverManager.getConnection(url, user, password);
    }
}
