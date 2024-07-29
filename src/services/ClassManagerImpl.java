package services;

import Model.FitnessClass;
import enums.ClassType;

import java.time.LocalDateTime;
import java.util.*;

public class ClassManagerImpl implements ClassManager {
    private Map<Integer, FitnessClass> classesById;
    private int classIdCounter;

    public ClassManagerImpl() {
        this.classesById = new HashMap<>();
        this.classIdCounter = 1;
    }

    @Override
    public FitnessClass createClass(ClassType type, int capacity, LocalDateTime scheduledTime) {
        FitnessClass fitnessClass = new FitnessClass(classIdCounter++, type, capacity, scheduledTime);
        classesById.put(fitnessClass.getId(), fitnessClass);
        return fitnessClass;
    }

    @Override
    public FitnessClass getClassById(int classId) {
        return classesById.get(classId);
    }
}
