import Model.FitnessClass;
import Model.User;
import enums.ClassType;
import enums.UserTier;
import services.*;

import java.time.LocalDateTime;

public class FitnessApp {
    private UserManager userManager;
    private ClassManager classManager;
    private BookingManager bookingManager;

    public FitnessApp() {
        this.userManager = new UserManagerImpl();
        this.classManager = new ClassManagerImpl();
        this.bookingManager = new BookingManagerImpl(classManager);
    }

    public void registerUser(User user) {
        userManager.registerUser(user);
    }

    public void loginUser(String email, String password) {
        userManager.login(email, password);
    }

    public FitnessClass createClass(ClassType type, int capacity, LocalDateTime scheduledTime) {
        return classManager.createClass(type, capacity, scheduledTime);
    }

    public void bookClass(User user, int classId) {
        bookingManager.bookClass(user, classId);
    }

    public void cancelBooking(User user, int bookingId) {
        bookingManager.cancelBooking(user, bookingId);
    }
}
