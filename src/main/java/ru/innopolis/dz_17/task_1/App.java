package ru.innopolis.dz_17.task_1;

import java.sql.*;
import java.util.List;

public class App {
    /**
     * 2)      Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
     * a)      Используя параметризированный запрос
     */
    public void task_2a(Connection connection, List<Object> objectList) throws SQLException {
        String sqlUser = "insert into users (id, name, birthday) values (?, ?, ?)";
        PreparedStatement preparedStatementUser = connection.prepareStatement(sqlUser);
        preparedStatementUser.setInt(1, (Integer) objectList.get(0));
        preparedStatementUser.setString(2, String.valueOf(objectList.get(1)));
        preparedStatementUser.setDate(3, (Date) objectList.get(2));
        preparedStatementUser.execute();

        String sqlRole = "insert into role (id, name, description) values (?, ?, ?)";
        PreparedStatement preparedStatementRole = connection.prepareStatement(sqlRole);
        preparedStatementRole.setInt(1, 1);
        preparedStatementRole.setString(2, RoleName.BILLING.getName());
        preparedStatementRole.setString(3, "desc1");
        preparedStatementRole.execute();
    }

    /**
     * 2)      Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
     * b)      Используя batch процесс
     */
    public void task_2b(Connection connection) throws SQLException {
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
    }

    /**
     * 3)      Сделать параметризированную выборку по login_ID и name одновременно
     */
    public void task_3(Connection connection) throws SQLException {
        String sql = "select * from users where login_id = ? and name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 10);
        preparedStatement.setString(2, "tttt");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
        }
    }

    /**
     * 4)      Перевести connection в ручное управление транзакциями
     * a)      Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
     * между sql операциями установить логическую точку сохранения(SAVEPOINT)
     */
    public void task_4a(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.execute("insert into users(login_id, name) values(10, 'test')");
        statement.execute("insert into users(login_id, name) values(11, 'test2')");
        Savepoint point = connection.setSavepoint();
        statement.execute("insert into users(login_id, name) values(15, 'test')");
        statement.execute("insert into users(login_id, name) values(16, 'test2')");
        connection.rollback(point);
        connection.setAutoCommit(true);
    }

    /**
     * 4)      Перевести connection в ручное управление транзакциями
     * b)      Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
     * между sql операциями установить точку сохранения (SAVEPOINT A),
     * намеренно ввести некорректные данные на последней операции,
     * что бы транзакция откатилась к логической точке SAVEPOINT A
     */
    public void task_4b(Connection connection) throws SQLException {
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
    }
}