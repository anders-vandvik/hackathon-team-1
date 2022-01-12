package main.java;

import main.java.problem.*;

import java.util.List;

public class Scorer {

    public static double calculateAssignmentScore(Video video, Cache cache) {
        // Get all requests for the video
        List<Request> requestsForVideo = Problem.videoToRequests.get(video);
        for (Request request : requestsForVideo) {
            int endpointId = request.getEndpointId();
            Endpoint endpoint = Problem.endpoints.get(endpointId);
            double latencyDataCenter = endpoint.getLatencyDataCenter();
            double latencyCache = endpoint.getCacheLatency(cache.getCacheId());
            double lowestLatency = Math.min(latencyDataCenter, latencyCache);
        }
        return 0.0;
    }
}
