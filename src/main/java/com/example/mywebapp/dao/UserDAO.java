package com.example.mywebapp.dao;

import com.example.mywebapp.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> allUsers();
    void addUser(User user);
    void deleteUser(int id);
    void editUser(User user);
    User getById(int id);
}
