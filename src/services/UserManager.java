package services;

import Model.User;

public interface UserManager {
    void registerUser(User user);

    void login(String email, String password);
}
