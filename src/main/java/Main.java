package main.java;

import main.java.problem.Problem;

public class Main {
    public static void main(String args[]) {
        IO io = new IO();
        io.readFile("/main/resources/instances/me_at_the_zoo.in.txt");

        System.out.println(Problem.videos);
        System.out.println(Problem.requests);
        System.out.println(Problem.endpoints);
        System.out.println(Problem.cacheIds);
    }
}
