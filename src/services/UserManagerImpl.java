package services;

import Model.User;
import enums.UserTier;

import java.util.*;

public class UserManagerImpl implements UserManager {
    private Map<String, User> usersByEmail;

    public UserManagerImpl() {
        this.usersByEmail = new HashMap<>();
    }

    @Override
    public void registerUser(User user) {
        if (usersByEmail.containsKey("user")) {
            System.out.println("User already exists with this email.");
            return;
        }
        usersByEmail.put(user.getEmail(), user);
        System.out.println("User registered successfully");
    }

    @Override
    public void login(String email, String password) {
        User user = usersByEmail.get(email);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login Successful for user " + user.getName());
            return;
        }
        System.out.println("Invalid email or password.");
    }
}
