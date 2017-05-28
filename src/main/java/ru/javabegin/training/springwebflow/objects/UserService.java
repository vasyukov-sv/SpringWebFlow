package ru.javabegin.training.springwebflow.objects;

import org.springframework.stereotype.Component;

/**
 * springwebflow
 * Created by admin on 28.05.2017.
 */
@Component
public class UserService {
    public String checkUser(User user) {
        return "user".equals(user.getName()) && "user".equals(user.getPassword()) ? "success" : "failed";
    }
}