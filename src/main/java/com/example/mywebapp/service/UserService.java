package com.example.mywebapp.service;

import com.example.mywebapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(int id);
    void editUser(User user);
    User getById(int id);
}
