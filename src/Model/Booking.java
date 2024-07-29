package Model;

import java.time.LocalDateTime;

public class Booking {
    private int id;
    private User user;
    private FitnessClass fitnessClass;
    private LocalDateTime bookingTime;

    public Booking(int id, User user, FitnessClass fitnessClass, LocalDateTime now) {
        this.id = id;
        this.user = user;
        this.fitnessClass = fitnessClass;
        this.bookingTime = now;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public FitnessClass getFitnessClass() {
        return fitnessClass;
    }
}
