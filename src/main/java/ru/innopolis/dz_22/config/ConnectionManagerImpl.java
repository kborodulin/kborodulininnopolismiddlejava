package ru.innopolis.dz_22.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManagerImpl.class);

    @Override
    public Connection connectDB() {
        String url = "jdbc:postgresql://localhost:5432/dz_22";
        String user = "postgres";
        String password = "postgres";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("Ошибка подключения к postgres: {}", e);
        }
        return connection;
    }
}