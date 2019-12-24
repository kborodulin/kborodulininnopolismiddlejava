package ru.innopolis.dz_22.dao;

import ru.innopolis.dz_22.pojo.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> listAllUser();
}