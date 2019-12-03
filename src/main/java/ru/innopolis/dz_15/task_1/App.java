package ru.innopolis.dz_15.task_1;

import java.sql.*;
import java.time.LocalDate;

public class App {
    /**
     * 2)      Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
     * a)      Используя параметризированный запрос
     */
    public void task_2a() {
        try (Connection connection = ConnectionDB.connectDB()) {
            String sqlUser = "insert into users (id, name, birthday) values (?, ?, ?)";
            PreparedStatement preparedStatementUser = connection.prepareStatement(sqlUser);
            preparedStatementUser.setInt(1, 1);
            preparedStatementUser.setString(2, "test1");
            preparedStatementUser.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatementUser.execute();

            String sqlRole = "insert into role (id, name, description) values (?, ?, ?)";
            PreparedStatement preparedStatementRole = connection.prepareStatement(sqlRole);
            preparedStatementRole.setInt(1, 1);
            preparedStatementRole.setString(2, RoleName.Billing.name());
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
    public void task_2b() {
        try (Connection connection = ConnectionDB.connectDB()) {
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
    public void task_3() {
        try (Connection connection = ConnectionDB.connectDB()) {
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
}