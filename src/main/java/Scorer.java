package main.java;

import main.java.problem.*;

import java.util.List;

public class Scorer {

    public static double calculateDelta(Video video, Cache cache) {
        // The endpoints that request the video and are connected to the cache
        List<Endpoint> endpoints = video.getEndpoints(cache);
        int delta = 0;
        for (Endpoint endpoint : endpoints) {
            Request request = endpoint.getRequest(video);
            int numberOfRequests = request.getNumberOfRequests();

            // Find the baseline latency (in case the video is available in another cache)
            Cache requestCache = request.getCache();
            int baselineLatency;
            if (requestCache != null) {
                baselineLatency = numberOfRequests * endpoint.getCacheLatency(requestCache);
            } else {
                baselineLatency = numberOfRequests * endpoint.getDataCenterLatency();
            }

            // Calculate delta
            int newLatency = numberOfRequests * endpoint.getCacheLatency(cache);
            delta += Math.max(newLatency - baselineLatency, 0);
        }
        return delta;
    }
}
