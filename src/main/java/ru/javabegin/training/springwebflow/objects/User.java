package ru.javabegin.training.springwebflow.objects;

import java.io.Serializable;

/**
 * springwebflow
 * Created by admin on 28.05.2017.
 */

public class User implements Serializable {
    private String name;
    private String password;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}