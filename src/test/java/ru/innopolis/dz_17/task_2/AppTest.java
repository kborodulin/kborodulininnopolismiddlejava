package ru.innopolis.dz_17.task_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class AppTest {
    private Connection connection;

    @Before
    public void openConnectionDB() throws SQLException {
        connection = ConnectionDB.connectDB();
    }

    @After
    public void closeConnectionDB() throws SQLException {
        connection.close();
    }

    @Test
    public void task_2aTest() {
        App app = new App();
        app.task_2a(connection);
    }

    @Test
    public void task_2bTest() {
        App app = new App();
        app.task_2b(connection);
    }

    @Test
    public void task_3Test() {
        App app = new App();
        app.task_3(connection);
    }

    @Test
    public void task_4aTest() {
        App app = new App();
        app.task_4a(connection);
    }

    @Test
    public void task_4bTest() {
        App app = new App();
        app.task_4b(connection);
    }
}
