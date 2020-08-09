package com.xyz.springbootdemo.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<User>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Bob", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(3, "David", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    User Save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    User deleteUserById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
