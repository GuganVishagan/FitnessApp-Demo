package Model;

import enums.UserTier;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private UserTier tier;
    private List<Booking> bookedClasses;

    public User(String id, String name, String email, String password, UserTier userTier) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tier = userTier;
        this.bookedClasses = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setTier(UserTier tier) {
        this.tier = tier;
    }

    public List<Booking> getBookedClasses() {
        return bookedClasses;
    }

    public UserTier getTier() {
        return tier;
    }
}