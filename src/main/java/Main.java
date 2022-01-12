package main.java;

import com.google.gson.Gson;
import main.java.model.Problem;
import main.java.model.ProblemBuilder;
import main.java.solution.OutputBuilder;
import main.java.solution.OutputDTO;
import main.java.solver.Solver;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        String filePath1 = "src/main/resources/instances/kittens.in.txt";
        String filePath2 = "src/main/resources/instances/me_at_the_zoo.in.txt";
        String filePath3 = "src/main/resources/instances/trending_today.in.txt";
        String filePath4 = "src/main/resources/instances/videos_worth_spreading.in.txt";

        Problem problem1 = new ProblemBuilder("kittens", filePath1).build();
        Solver solver1 = new Solver(problem1);
        solver1.solve();

        Problem problem2 = new ProblemBuilder("me_at_the_zoo", filePath2).build();
        Solver solver2 = new Solver(problem2);
        solver2.solve();

        Problem problem3 = new ProblemBuilder("trending_today", filePath3).build();
        Solver solver3 = new Solver(problem3);
        solver3.solve();

        Problem problem4 = new ProblemBuilder("videos_worth_spreading", filePath4).build();
        Solver solver4 = new Solver(problem4);
        solver4.solve();

        OutputDTO output = new OutputBuilder("Team 1", problem1, problem2, problem3, problem4).build();
        submitSolution(output);
    }

    private static void submitSolution(OutputDTO output) {
        HttpRequest request = null;
        try {
            String outputJson = new Gson().toJson(output);
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://4wp2xwcq3h.execute-api.eu-west-1.amazonaws.com/resolve-hackathon"))
                    .POST(HttpRequest.BodyPublishers.ofString(outputJson))
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.body());
    }

}
