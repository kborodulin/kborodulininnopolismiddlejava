package ru.innopolis.dz_22.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.dz_22.config.ConnectionManager;
import ru.innopolis.dz_22.config.ConnectionManagerImpl;
import ru.innopolis.dz_22.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private ConnectionManager connectionManager = new ConnectionManagerImpl();

    @Override
    public void addUser(User user) {
        try (Connection connection = connectionManager.connectDB()) {
            String sqlUser = "insert into users (login, password, surname, patronymic, name, email, phone) " +
                    "values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementUser = connection.prepareStatement(sqlUser);
            preparedStatementUser.setString(1, user.getLogin());
            preparedStatementUser.setString(2, user.getPassword());
            preparedStatementUser.setString(3, user.getSurname());
            preparedStatementUser.setString(4, user.getPatronymic());
            preparedStatementUser.setString(5, user.getName());
            preparedStatementUser.setString(6, user.getEmail());
            preparedStatementUser.setString(7, user.getPhone());
            preparedStatementUser.execute();
        } catch (SQLException e) {
            LOGGER.error("{}", e);
        }
    }

    @Override
    public List<User> listAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = connectionManager.connectDB()) {
            String sqlUser = "select * from users";
            PreparedStatement preparedStatementUser = connection.prepareStatement(sqlUser);
            ResultSet resultSet = preparedStatementUser.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setSurname(resultSet.getString("surname"));
                user.setPatronymic(resultSet.getString("patronymic"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("{}", e);
        }
        return users;
    }

    @Override
    public void deleteUser(int id) {
        try (Connection connection = connectionManager.connectDB()) {
            String sqlUser = "delete from users where id = ?";
            PreparedStatement preparedStatementUser = connection.prepareStatement(sqlUser);
            preparedStatementUser.setInt(1, id);
            preparedStatementUser.execute();
        } catch (SQLException e) {
            LOGGER.error("{}", e);
        }
    }
}