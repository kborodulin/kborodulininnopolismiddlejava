package ru.innopolis.dz_22.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static ru.innopolis.dz_22.utils.ServletUtils.*;

public class ConnectionManagerImpl implements ConnectionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManagerImpl.class);

    @Override
    public Connection connectDB() {
        LOGGER.debug("Try connection with {} {} {}", DB_URL, DB_LOGIN, DB_PASSWORD);
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            LOGGER.debug("Connection SUCCESS");
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("Connection error: {}", e.getMessage());
        }
        return connection;
    }
}