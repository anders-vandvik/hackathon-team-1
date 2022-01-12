package main.java;

import main.java.problem.Cache;
import main.java.problem.Endpoint;
import main.java.problem.Problem;
import main.java.problem.Video;

import java.io.*;
import java.util.*;

public class ProblemBuilder {

    private final String filePath;

    public ProblemBuilder(String filePath) {
        this.filePath = filePath;
    }

    public Problem build() {
        List<List<Integer>> content = readLines();

        List<Integer> header = content.get(0);
//        int numVideos = header.get(0);
        int numEndpoints = header.get(1);
        int numRequests = header.get(2);
        int numCaches = header.get(3);
        int cacheSize = header.get(4);

        Map<Integer, Cache> idCaches = buildCaches(numCaches, cacheSize);
        Map<Integer, Video> idVideos = buildIdVideos(content.get(1));

        Map<Integer, Endpoint> idEndpoints = new HashMap<>();

        int idx = 2;

        for (int i = 0; i < numEndpoints; i++) {
            List<Integer> endpointEntry = content.get(idx++);

            int dataCentreLatency = endpointEntry.get(0);
//            Endpoint endpoint = new Endpoint(endpointId, dataCentreLatency);
        }

//        int idx = 2;
//        int endpointId = 0;
//        while (idx < content.size()) {
//            List<Integer> endpointEntry = content.get(idx);
//
//            int dataCentreLatency = endpointEntry.get(0);
//            Endpoint endpoint = new Endpoint(endpointId, dataCentreLatency);
//            idEndpoints.put(endpoint.getId(), endpoint);
//
//            int numConnectedCaches = endpointEntry.get(1);
//
//            for (int i = 1; i <= numConnectedCaches; i++) {
//                idx++;
//                List<Integer> cacheEntry = content.get(idx);
//
//                Cache cache = idCaches.get(cacheEntry.get(0));
//                int latency = cacheEntry.get(1);
//                endpoint.addCacheLatency(cache, latency);
//            }
//
//            endpointId++;
//            idx++;
//        }

        return null;
    }

    private Map<Integer, Cache> buildCaches(int numCaches, int cacheSize) {
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
