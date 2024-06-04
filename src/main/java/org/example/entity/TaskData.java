package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String task) {
        switch (task) {
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(bobsTasks, annsTasks, carolsTasks);
            default:
                System.out.println("Yanlis girdi");
        }
        return Set.of();
    }

    public static Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> set : sets) {
            union.addAll(set);
        }
        return union;
    }

    public static Set<Task> getIntersection(Set<Task> task1, Set<Task> task2) {
        Set<Task> intersect = new HashSet<>(task1);
        intersect.retainAll(task2);
        return intersect;
    }

    public static Set<Task> getDifferences(Set<Task> task1, Set<Task> task2) {
        Set<Task> difference = new HashSet<>(task1);
        difference.removeAll(task2);
        return difference;
    }

}
