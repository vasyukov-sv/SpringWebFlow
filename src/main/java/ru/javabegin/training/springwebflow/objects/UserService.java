package ru.javabegin.training.springwebflow.objects;

import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

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
        if (userExistName(user)) return "exist";
        users.add(user);
        return "success";

    }

    private boolean userExistName(User user) {
        return users.stream().anyMatch(u -> u.getName().toLowerCase().equals(user.getName().toLowerCase()));
    }

    public boolean userExist(User user, RequestContext context) {
        System.out.println(context.getFlowScope().asMap());
        return users.contains(user);
    }
}