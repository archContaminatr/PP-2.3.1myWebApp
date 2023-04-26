package com.example.dao;

import com.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOImpl implements UserDAO {

    private static AtomicInteger AUTO_ID = new AtomicInteger(1);
    private static Map<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setId(AUTO_ID.getAndIncrement());
        user1.setFirstName("Иван");
        user1.setLastName("Смирнов");
        user1.setAge(42);
        users.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(AUTO_ID.getAndIncrement());
        user2.setFirstName("Кирилл");
        user2.setLastName("Батулин");
        user2.setAge(14);
        users.put(user2.getId(), user2);

        User user3 = new User();
        user3.setId(AUTO_ID.getAndIncrement());
        user3.setFirstName("Даниил");
        user3.setLastName("Каверзин");
        user3.setAge(24);
        users.put(user3.getId(), user3);

    }
    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void addUser(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user.getId());
    }

    @Override
    public void editUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }

}
