package com.pablito.db;

import com.pablito.model.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserDb {
    private static UserDb db;

    private List<User> users;

    private UserDb() {
        this.users = new LinkedList<>();
        users.add(new User("admin@admin.com", "pass", "admin", Arrays.asList("admin", "user")));
    }

    public static UserDb getInstance() {
        if (db == null) {
            db = new UserDb();
        }
        return db;
    }

    public Optional<User> checkLogin(final String username, final String password) {
      return users.stream()
                .filter(user -> user.getUserName().equalsIgnoreCase(username))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }

    public void addUser(final String userName, final String email, final String password, final List<String> roles) {
        users.add(new User(email, password, userName, roles));
    }
}
