package ru.innopolis.dz_17.task_2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @Spy
    private ConnectionDB connectionDB;

    @Test
    public void task_2aTest() throws SQLException {
        when(connectionDB.connectDB()).thenReturn(connection);
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        App app = new App();
        app.task_2a(connectionDB);
    }

    @Test
    public void task_2bTest() throws SQLException {
        when(connectionDB.connectDB()).thenReturn(connection);
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        App app = new App();
        app.task_2b(connectionDB);
    }

    @Test
    public void task_3Test() throws SQLException {
        when(connectionDB.connectDB()).thenReturn(connection);
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(connection.prepareStatement(any()).executeQuery()).thenReturn(resultSet);
        App app = new App();
        app.task_3(connectionDB);
    }

    @Test
    public void task_4aTest() throws SQLException {
        when(connectionDB.connectDB()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(preparedStatement);
        App app = new App();
        app.task_4a(connectionDB);
    }

    @Test
    public void task_4bTest() throws SQLException {
        when(connectionDB.connectDB()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(preparedStatement);
        App app = new App();
        app.task_4b(connectionDB);
    }
}