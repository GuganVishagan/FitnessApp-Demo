package Model;

import enums.ClassType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FitnessClass {
    private int id;
    private ClassType type;
    private int capacity;
    private LocalDateTime scheduledTime;
    private List<User> attendees;
    private Queue<User> waitlist;

    public FitnessClass(int id, ClassType type, int capacity, LocalDateTime scheduledTime) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.scheduledTime = scheduledTime;
        this.attendees = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public int getCapacity() {
        return capacity;
    }

    public Queue<User> getWaitlist() {
        return waitlist;
    }

    public ClassType getType() {
        return type;
    }
}