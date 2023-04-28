package com.example.dao;

import com.example.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> allUsers();
    void addUser(User user);
    void deleteUser(int id);
    void editUser(User user);
    User getById(int id);
}
