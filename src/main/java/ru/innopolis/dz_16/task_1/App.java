package ru.innopolis.dz_16.task_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * 2)      Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
     * a)      Используя параметризированный запрос
     */
    public void task_2a() {
        try (Connection connection = ConnectionDB.connectDB()) {
            LOGGER.info("Вставим запись в таблицу users;");
            int primaryKey = 1;
            String sqlUser = "insert into users (id, name, birthday) values (?, ?, ?)";
            PreparedStatement preparedStatementUser = connection.prepareStatement(sqlUser);
            preparedStatementUser.setInt(1, primaryKey);
            preparedStatementUser.setString(2, "test1");
            preparedStatementUser.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatementUser.execute();
            LOGGER.info("Запись в таблицу с id = {} успешно вставлена;", primaryKey);

            String sqlRole = "insert into role (id, name, description) values (?, ?, ?)";
            PreparedStatement preparedStatementRole = connection.prepareStatement(sqlRole);
            preparedStatementRole.setInt(1, 1);
            preparedStatementRole.setString(2, RoleName.BILLING.getName());
            preparedStatementRole.setString(3, "desc1");
            preparedStatementRole.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

    /**
     * 2)      Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
     * b)      Используя batch процесс
     */
    public void task_2b() {
        try (Connection connection = ConnectionDB.connectDB()) {
            LOGGER.info("Вставим запись в таблицу users черех Batch;");
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
            LOGGER.info("Записи в таблицу users успешно вставлены через Batch;");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

    /**
     * 3)      Сделать параметризированную выборку по login_ID и name одновременно
     */
    public void task_3() {
        try (Connection connection = ConnectionDB.connectDB()) {
            LOGGER.info("Сделана выборка по login_ID и name;");
            String sql = "select * from users where login_id = ? and name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 10);
            preparedStatement.setString(2, "tttt");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

    /**
     * 4)      Перевести connection в ручное управление транзакциями
     * a)      Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
     * между sql операциями установить логическую точку сохранения(SAVEPOINT)
     */
    public void task_4a() {
        try (Connection connection = ConnectionDB.connectDB()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("insert into users(login_id, name) values(10, 'test')");
            statement.execute("insert into users(login_id, name) values(11, 'test2')");
            Savepoint point = connection.setSavepoint();
            statement.execute("insert into users(login_id, name) values(15, 'test')");
            statement.execute("insert into users(login_id, name) values(16, 'test2')");
            connection.rollback(point);
            connection.setAutoCommit(true);
            LOGGER.info("Эксперементы с SAVEPOINT;");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
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
    public void task_4b() {
        try (Connection connection = ConnectionDB.connectDB()) {
            LOGGER.info("Эксперементы с SAVEPOINT с ошибкой;");
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
                LOGGER.error(e.getMessage(), e);
                connection.rollback(pointA);
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
}