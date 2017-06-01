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

    public String createUser(User user) {
        if (userExist(user)) return "exist";
        users.add(user);
        return "success";
    }

    public boolean userExist(User user) {
        return users.stream().anyMatch(u -> u.getName().toLowerCase().equals(user.getName().toLowerCase()));
    }
}