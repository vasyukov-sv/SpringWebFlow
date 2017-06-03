package ru.javabegin.training.springwebflow.objects;

import org.springframework.binding.message.MessageBuilder;
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

    public String createUser(User user, RequestContext context) {
        if (userExistName(user)) {
            context.getMessageContext().addMessage(new MessageBuilder().code("userAlredyExist").build());
            context.getMessageContext().addMessage(new MessageBuilder().code("enterOtherName").build());
            return "exist";
        }
        users.add(user);

        context.getMessageContext().addMessage(new MessageBuilder().code("userCreated").build());
        context.getMessageContext().addMessage(new MessageBuilder().code("enter").build());
        return "success";

    }

    private boolean userExistName(User user) {
        return users.stream().anyMatch(u -> u.getName().toLowerCase().equals(user.getName().toLowerCase()));
    }

    public boolean userExist(User user, RequestContext context) {
        System.out.println(context.getFlowScope().asMap());
        context.getMessageContext().addMessage(new MessageBuilder().code("checkUser").build());
        return users.contains(user);
    }
}