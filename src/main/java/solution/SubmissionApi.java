package main.java.solution;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SubmissionApi {

    public void submitSolution(SolutionSubmissionRequest solution) {
        try {
            String solutionAsJson = new Gson().toJson(solution);
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://4wp2xwcq3h.execute-api.eu-west-1.amazonaws.com/resolve-hackathon"))
                .POST(HttpRequest.BodyPublishers.ofString(solutionAsJson))
                .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);

        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
