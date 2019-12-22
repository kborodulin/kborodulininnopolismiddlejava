package ru.innopolis.dz_17.task_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class AppTest {
    private Connection connection;
    private List<Object> objectList = new ArrayList<>();
    private App app = new App();

    @Before
    public void openConnectionDB() throws SQLException {
        connection = ConnectionDB.connectDB();
        objectList.add(1);
        objectList.add("test1");
        objectList.add(Date.valueOf(LocalDate.now()));
    }

    @Test
    public void task_2aTest() throws SQLException {
        try {
            app.task_2a(connection, objectList);
        } catch (Exception e) {
            fail("Exception " + e);
        }
    }

    @Test
    public void task_2bTest() {
        try {
            app.task_2b(connection);
        } catch (SQLException e) {
            fail("Exception " + e);
        }
    }

    @Test
    public void task_3Test() {
        try {
            app.task_3(connection);
        } catch (SQLException e) {
            fail("Exception " + e);
        }
    }

    @Test
    public void task_4aTest() {
        try {
            app.task_4a(connection);
        } catch (SQLException e) {
            fail("Exception " + e);
        }
    }

    @Test
    public void task_4bTest() {
        try {
            app.task_4b(connection);
        } catch (SQLException e) {
            fail("Exception " + e);
        }
    }

    @After
    public void closeConnectionDB() throws SQLException {
        connection.close();
    }
}
