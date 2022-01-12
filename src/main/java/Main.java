package main.java;

import main.java.model.Problem;
import main.java.model.ProblemBuilder;
import main.java.solver.Solver;

public class Main {

    public static void main(String[] args) {
//        String filePath = "/Users/kuba/Dev/visma/hack/hackathon-team-1/src/main/resources/instances/me_at_the_zoo.in.txt";
//        String filePath = "/Users/kuba/Dev/visma/hack/hackathon-team-1/src/main/resources/instances/trending_today.in.txt";
        String filePath = "/Users/kuba/Dev/visma/hack/hackathon-team-1/src/main/resources/instances/kittens.in.txt";

        Problem problem = new ProblemBuilder(filePath).build();
        Solver solver = new Solver(problem);
        solver.solve();
    }

}
