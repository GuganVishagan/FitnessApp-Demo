import Model.Booking;
import Model.FitnessClass;
import Model.User;
import enums.ClassType;
import enums.UserTier;

import java.time.LocalDateTime;

public class FitnessAppDemo {
    public static void main(String[] args) {
        FitnessApp fitnessApp = new FitnessApp();

        // Register users
        User harsh = new User("1", "Harsh", "harsh@gmmail.com", "harsh@123", UserTier.PLATINUM);
        User alok = new User("2", "Alok", "alok@gmail.com", "alok@123", UserTier.GOLD);
        fitnessApp.registerUser(harsh);
        fitnessApp.registerUser(alok);
        // Login users
        fitnessApp.loginUser("harsh@gmmail.com", "harsh@123");
        fitnessApp.loginUser("alok@gmail.com", "alok@123");

        FitnessClass yogaClass = fitnessApp.createClass(ClassType.YOGA, 10, LocalDateTime.of(2024, 8, 1, 10, 0));
        FitnessClass gymClass = fitnessApp.createClass(ClassType.GYM, 5, LocalDateTime.of(2024, 8, 1, 12, 0));

        // Users book classes
        fitnessApp.bookClass(harsh, yogaClass.getId());
        fitnessApp.bookClass(alok, gymClass.getId());

        //Harsh cancels her booking
        Booking booking = harsh.getBookedClasses().get(0);
        fitnessApp.cancelBooking(harsh, booking.getId());
    }
}
