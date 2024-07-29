package services;

import Model.Booking;
import Model.FitnessClass;
import Model.User;

import java.time.LocalDateTime;
import java.util.*;

public class BookingManagerImpl implements BookingManager {
    private Map<Integer, Booking> bookingsById;
    private int bookingIdCounter;
    ClassManager classManager;

    public BookingManagerImpl(ClassManager classManager) {
        this.bookingsById = new HashMap<>();
        this.bookingIdCounter = 1;
        this.classManager = classManager;
    }

    @Override
    public void bookClass(User user, int classId) {
        FitnessClass fitnessClass = classManager.getClassById(classId);
        if (fitnessClass == null) {
            System.out.println("Class not found.");
            return;
        }
        if (user.getBookedClasses().size() >= user.getTier().getBookingLimit()) {
            System.out.println("Booking limit reached for your tier");
        }
        if (fitnessClass.getAttendees().size() < fitnessClass.getCapacity()) {
            Booking booking = new Booking(bookingIdCounter++, user, fitnessClass, LocalDateTime.now());
            bookingsById.put(booking.getId(), booking);
            fitnessClass.getAttendees().add(user);
            user.getBookedClasses().add(booking);
            System.out.println(fitnessClass.getType() + " booked successfully");
        } else {
            fitnessClass.getWaitlist().offer(user);
            System.out.println("Added to waitlist");
        }
    }

    @Override
    public void cancelBooking(User user, int bookingId) {
        Booking booking = bookingsById.get(bookingId);
        if (booking == null || !booking.getUser().equals(user)) {
            System.out.println("Booking not found or unauthorized.");
        }
        FitnessClass fitnessClass = booking.getFitnessClass();
        fitnessClass.getAttendees().remove(user);
        user.getBookedClasses().remove(booking);
        bookingsById.remove(bookingId);
        System.out.println("Booking cancelled");
        handleWaitlist(fitnessClass);
    }

    @Override
    public void handleWaitlist(FitnessClass fitnessClass) {
        if (fitnessClass.getAttendees().size() < fitnessClass.getCapacity() && !fitnessClass.getWaitlist().isEmpty()) {
            User user = fitnessClass.getWaitlist().poll();
            Booking booking = new Booking(bookingIdCounter++, user, fitnessClass, LocalDateTime.now());
            bookingsById.put(booking.getId(), booking);
            fitnessClass.getAttendees().add(user);
            user.getBookedClasses().add(booking);
        }
    }
}
