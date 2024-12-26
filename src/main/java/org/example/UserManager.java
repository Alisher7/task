package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> users = new ArrayList<>();
    private int id = 0;

    public UserManager() {
        users = new ArrayList<>();
    }

    public static List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        user.setId(id++);
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    static {
        User admin = new User("admin", "admin");
        User user = new User("user", "user");

        users.add(admin);
        users.add(user);
    }

    @Override
    public String toString() {
        return users.toString();
    }

}
