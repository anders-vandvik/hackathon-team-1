package main.java.model;

import main.java.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemBuilder {

    private final String id;
    private final String filePath;

    public ProblemBuilder(String id, String filePath) {
        this.id = id;
        this.filePath = filePath;
    }

    public Problem build() {
        List<List<Integer>> content = readLines();

        List<Integer> header = content.get(0);
        int numEndpoints = header.get(1);
        int numCaches = header.get(3);
        int cacheSize = header.get(4);

        Map<Integer, Cache> idCaches = buildIdCaches(numCaches, cacheSize);
        Map<Integer, Video> idVideos = buildIdVideos(content.get(1));

        Map<Integer, Endpoint> idEndpoints = buildIdEndpoints(numEndpoints, idCaches, idVideos, content);

        List<Cache> caches = new ArrayList<>(idCaches.values());
        List<Endpoint> endpoints = new ArrayList<>(idEndpoints.values());

        return new Problem(id, caches, endpoints);
    }

    private Map<Integer, Endpoint> buildIdEndpoints(int numEndpoints, Map<Integer, Cache> idCaches,
                                                    Map<Integer, Video> idVideos, List<List<Integer>> content) {
        Map<Integer, Endpoint> idEndpoints = new HashMap<>();
        int idx = 2;
        for (int id = 0; id < numEndpoints; id++) {
            List<Integer> endpointHeader = content.get(idx++);
            int latencyDataCenter = endpointHeader.get(0);
            int numCaches = endpointHeader.get(1);

            Endpoint endpoint = new Endpoint(id, latencyDataCenter);
            idEndpoints.put(id, endpoint);

            for (int i = 0; i < numCaches; i++) {
                List<Integer> cacheEntry = content.get(idx++);

                Cache cache = idCaches.get(cacheEntry.get(0));
                int latency = cacheEntry.get(1);
                endpoint.addCacheLatency(cache, latency);
            }
        }

        while (idx < content.size()) {
            List<Integer> requestEntry = content.get(idx);

            Video video = idVideos.get(requestEntry.get(0));
            Endpoint endpoint = idEndpoints.get(requestEntry.get(1));
            int numRequests = requestEntry.get(2);

            Request request = new Request(numRequests);
            endpoint.addVideoRequest(video, request);

            idx++;
        }

        return idEndpoints;
    }

    private Map<Integer, Cache> buildIdCaches(int numCaches, int cacheSize) {
        Map<Integer, Cache> idCaches = new HashMap<>();
        for (int id = 0; id < numCaches; id++) {
            idCaches.put(id, new Cache(id, cacheSize));
        }
        return idCaches;
    }

    private Map<Integer, Video> buildIdVideos(List<Integer> line) {
        Map<Integer, Video> idVideos = new HashMap<>();
        int id = 0;
        for (Integer size : line) {
            idVideos.put(id, new Video(id, size));
            id++;
        }
        return idVideos;
    }

    private List<List<Integer>> readLines() {
        ArrayList<List<Integer>> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.ready()) {
                result.add(toIntList(br.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Integer> toIntList(String line) {
        List<Integer> intList = new ArrayList<>();
        for (String el : line.split(" ")) {
            intList.add(Integer.valueOf(el));
        }
        return intList;
    }

}
