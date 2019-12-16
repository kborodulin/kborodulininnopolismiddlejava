package ru.innopolis.dz_17.task_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection connectDB() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/dz_15";
        String user = "postgres";
        String password = "postgres";
        return DriverManager.getConnection(url, user, password);
    }
}
