package main.java;

import main.java.problem.Problem;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String filePath = "/Users/kuba/Dev/visma/hack/hackathon-team-1/src/main/resources/instances/me_at_the_zoo.in.txt";

        Problem build = new ProblemBuilder(filePath).build();
    }

}
