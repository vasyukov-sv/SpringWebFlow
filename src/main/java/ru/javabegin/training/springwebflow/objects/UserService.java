package ru.javabegin.training.springwebflow.objects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * springwebflow
 * Created by admin on 28.05.2017.
 */
@Component
public class UserService {
    private final ArrayList<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("user", "user"));
    }

    public void createUser(User user) {
        users.add(user);
    }

    public boolean userExist(User user) {
        return users.contains(user);
    }
}