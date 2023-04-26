package com.example.service;

import com.example.dao.UserDAO;
import com.example.dao.UserDAOImpl;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) { this.userDAO = userDAO; }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void editUser(User user) {
        userDAO.editUser(user);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
