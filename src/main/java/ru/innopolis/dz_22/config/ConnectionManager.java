package ru.innopolis.dz_22.config;

import java.sql.Connection;

public interface ConnectionManager {
    Connection connectDB();
}