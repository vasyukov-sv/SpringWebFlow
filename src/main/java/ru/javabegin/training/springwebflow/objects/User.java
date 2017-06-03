package ru.javabegin.training.springwebflow.objects;

import java.io.Serializable;

/**
 * springwebflow
 * Created by admin on 28.05.2017.
 */

public class User implements Serializable {
    private static final long serialVersionUID = -8810087547308216409L;
    private String name;
    private String password;

    public User() {
    }

    User(String name, String password) {
        this.name = name;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return (name != null ? name.equals(user.name) : user.name == null) &&
                (password != null ? password.equals(user.password) : user.password == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}