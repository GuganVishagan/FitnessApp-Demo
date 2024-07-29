package services;

import Model.FitnessClass;
import enums.ClassType;

import java.time.LocalDateTime;

public interface ClassManager {
    FitnessClass createClass(ClassType type, int capacity, LocalDateTime scheduledTime);

    FitnessClass getClassById(int classId);
}
