package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();
    private int id = 0;

    public UserManager() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void findTask(int id) {
        ArrayList<Task> list = new ArrayList<>();

    }

    public void addUser(User user) {
        user.setId(id++);
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

}
