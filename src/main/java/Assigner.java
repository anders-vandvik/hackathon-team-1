package main.java;

import main.java.problem.Problem;

import java.util.HashSet;
import java.util.Set;

public class Assigner {

    public static Set<Set<Integer>> getAssignments() {
        // Cartesian product of videoIds and cacheIds
        Set<Set<Integer>> assignments = new HashSet<>();
        for (int i = 0; i < Problem.videos.size(); i++) {
            for (int j = 0; j < Problem.cacheIds.size(); j++) {
                Set<Integer> assignment = new HashSet<>();
                assignment.add(i);
                assignment.add(j);
                assignments.add(assignment);
            }
        }
        return assignments;
    }
}
