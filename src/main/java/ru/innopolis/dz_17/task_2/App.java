package ru.innopolis.dz_17.task_2;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class App {
    /**
     * 2)      Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
     * a)      Используя параметризированный запрос
     */
    public void task_2a(ConnectionDB connectionDB) {
        try (Connection connection = connectionDB.connectDB()) {
            String sqlUser = "insert into users (id, name, birthday) values (?, ?, ?)";
            PreparedStatement preparedStatementUser = connection.prepareStatement(sqlUser);
            preparedStatementUser.setInt(1, 1);
            preparedStatementUser.setString(2, "test1");
            preparedStatementUser.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatementUser.execute();

            String sqlRole = "insert into role (id, name, description) values (?, ?, ?)";
            PreparedStatement preparedStatementRole = connection.prepareStatement(sqlRole);
            preparedStatementRole.setInt(1, 1);
            preparedStatementRole.setString(2, RoleName.BILLING.getName());
            preparedStatementRole.setString(3, "desc1");
            preparedStatementRole.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2)      Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
     * b)      Используя batch процесс
     */
    public void task_2b(ConnectionDB connectionDB) {
        try (Connection connection = connectionDB.connectDB()) {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("insert into users (id, name) values (?, ?)");
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "test1");
            preparedStatement.addBatch();
            preparedStatement = connection.prepareStatement("insert into users (id, name) values (?, ?)");
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "test2");
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 3)      Сделать параметризированную выборку по login_ID и name одновременно
     */
    public void task_3(ConnectionDB connectionDB) {
        try (Connection connection = connectionDB.connectDB()) {
            String sql = "select * from users where login_id = ? and name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 10);
            preparedStatement.setString(2, "tttt");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4)      Перевести connection в ручное управление транзакциями
     * a)      Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
     * между sql операциями установить логическую точку сохранения(SAVEPOINT)
     */
    public void task_4a(ConnectionDB connectionDB) {
        try (Connection connection = connectionDB.connectDB()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("insert into users(login_id, name) values(10, 'test')");
            statement.execute("insert into users(login_id, name) values(11, 'test2')");
            Savepoint point = connection.setSavepoint();
            statement.execute("insert into users(login_id, name) values(15, 'test')");
            statement.execute("insert into users(login_id, name) values(16, 'test2')");
            connection.rollback(point);
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4)      Перевести connection в ручное управление транзакциями
     * b)      Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
     * между sql операциями установить точку сохранения (SAVEPOINT A),
     * намеренно ввести некорректные данные на последней операции,
     * что бы транзакция откатилась к логической точке SAVEPOINT A
     */
    public void task_4b(ConnectionDB connectionDB) throws SQLException {
        try (Connection connection = connectionDB.connectDB()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("insert into users(login_id, name) values(10, 'test')");
            statement.execute("insert into users(login_id, name) values(11, 'test2')");
            statement.execute("insert into users(login_id, name) values(15, 'test')");
            statement.execute("insert into users(login_id, name) values(25, 'test')");
            Savepoint pointA = connection.setSavepoint();
            statement.execute("insert into users(login_id, name) values(16, 'test2')");
            Savepoint pointB = connection.setSavepoint();
            try {
                statement.execute("insert into role(name) values('test')");
            } catch (Exception e) {
                connection.rollback(pointA);
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}