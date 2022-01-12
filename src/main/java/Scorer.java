package main.java;

import main.java.problem.*;

import java.util.List;

public class Scorer {

    public static double calculateTotalLatency(Video video, Cache cache) {
        // The endpoints that request the video and are connected to the cache
        List<Endpoint> endpoints = video.getEndpoints(cache);
        int totalLatency = 0;
        for (Endpoint endpoint : endpoints) {
            int endpointLatency = endpoint.getCacheLatency(cache);
            int dataCenterLatency = endpoint.getDataCenterLatency();
            totalLatency += Math.min(endpointLatency, dataCenterLatency);
        }
        return totalLatency;
    }
}
