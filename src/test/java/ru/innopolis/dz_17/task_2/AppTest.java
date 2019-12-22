package ru.innopolis.dz_17.task_2;

import org.junit.Before;
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

    private App app = new App();

    @Before
    public void init() throws SQLException {
        when(connectionDB.connectDB()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(preparedStatement);
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(connection.prepareStatement(any()).executeQuery()).thenReturn(resultSet);
    }

    @Test
    public void task_2aTest() throws SQLException {
        app.task_2a(connectionDB);
        verify(connection, atLeast(1)).prepareStatement(any());
        verify(preparedStatement, atLeast(1)).execute();
    }

    @Test
    public void task_2bTest() throws SQLException {
        app.task_2b(connectionDB);
        verify(connection, atLeast(1)).prepareStatement(any());
        verify(preparedStatement, atLeast(1)).addBatch();
        verify(preparedStatement, atLeast(1)).executeBatch();
    }

    @Test
    public void task_3Test() throws SQLException {
        app.task_3(connectionDB);
        verify(connection, atLeast(1)).prepareStatement(any());
        verify(preparedStatement, atLeast(1)).executeQuery();
    }

    @Test
    public void task_4aTest() throws SQLException {
        app.task_4a(connectionDB);
        verify(connection, atLeast(1)).createStatement();
        verify(connection, atLeast(1)).rollback(any());
        verify(connection, atLeast(1)).setAutoCommit(true);
    }

    @Test
    public void task_4bTest() throws SQLException {
        app.task_4b(connectionDB);
        verify(connection, atLeast(1)).createStatement();
        verify(connection, atLeast(1)).setSavepoint();
    }
}