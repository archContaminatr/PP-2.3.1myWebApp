package com.example.dao;

import com.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery(
                "select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

}
