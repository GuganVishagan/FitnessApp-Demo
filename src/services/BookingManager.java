package services;

import Model.FitnessClass;
import Model.User;

public interface BookingManager {
    void bookClass(User user, int classId);

    void cancelBooking(User user, int bookingId);

    void handleWaitlist(FitnessClass fitnessClass);
}
