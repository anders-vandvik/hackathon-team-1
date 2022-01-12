package main.java;

import main.java.problem.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IO {

    public void readFile(String problemFile) {
        InputStream inputStream = IO.class.getResourceAsStream(problemFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            Header header = parseHeader(br.readLine());
            Problem.videos = parseVideos(br.readLine());

            Problem.endpoints = new ArrayList<>();
            for (int i = 0; i < header.endpointCount; i++) {
                Endpoint endpoint = parseEndpoint(br.readLine(), i);
                Problem.endpoints.add(endpoint);

                for (int j = 0; j < endpoint.getNumberOfConnectedCaches(); j++) {
                    Map<Integer, Double> cacheLatencyMapping = parseCacheLatencyMapping(br.readLine());
                    endpoint.setCacheIdToLatency(cacheLatencyMapping);
                }
            }

            Problem.requests = new ArrayList<>();
            for (int k = 0; k < header.requestCount; k++) {
                Request request = parseRequest(br.readLine(), k);
                Problem.requests.add(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Header parseHeader(String headerString) {
        String[] headerValues = headerString.split(" ");

        Header header = new Header();
        header.videoCount = Integer.parseInt(headerValues[0]);
        header.endpointCount = Integer.parseInt(headerValues[1]);
        header.requestCount = Integer.parseInt(headerValues[2]);
        header.cacheCount = Integer.parseInt(headerValues[3]);
        header.cacheSize = Integer.parseInt(headerValues[4]);

        return header;
    }

    private List<Video> parseVideos(String videosString) {
        String[] videoValues = videosString.split(" ");

        List<Video> videos = new ArrayList<>(videoValues.length);
        for (int i = 0; i < videoValues.length; i++) {
            videos.add(new Video(i, Integer.parseInt(videoValues[i])));
        }

        return videos;
    }

    private Endpoint parseEndpoint(String endpointString, int id) {
        String[] endpointDefinition = endpointString.split(" ");

        Endpoint endpoint = new Endpoint(
                id,
                Double.parseDouble(endpointDefinition[0]),
                Integer.parseInt(endpointDefinition[1])
        );

        return endpoint;
    }

    private Map<Integer, Double> parseCacheLatencyMapping(String cacheLatencyString) {
        Map<Integer, Double> result = new HashMap<>();

        String[] cacheLatencyDefinition = cacheLatencyString.split(" ");

        result.put(Integer.parseInt(cacheLatencyDefinition[0]), Double.parseDouble(cacheLatencyDefinition[1]));

        return result;
    }

    private Request parseRequest(String requestString, int id) {
        String[] requestDefinition = requestString.split(" ");

        Request request = new Request(
                id,
                Integer.parseInt(requestDefinition[0]),
                Integer.parseInt(requestDefinition[1]),
                Double.parseDouble(requestDefinition[2])
        );

        return request;
    }
}
