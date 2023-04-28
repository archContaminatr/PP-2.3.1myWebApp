package com.example.service;

import com.example.dao.UserDAO;
import com.example.dao.UserDAOImpl;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public void editUser(User user) {
        userDAO.editUser(user);
    }

    @Transactional
    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
