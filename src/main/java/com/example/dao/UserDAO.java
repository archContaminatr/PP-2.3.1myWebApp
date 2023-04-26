package com.example.dao;

import com.example.model.User;

import java.util.List;

public interface UserDAO {

    List<User> allUsers();
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getById(int id);
}
