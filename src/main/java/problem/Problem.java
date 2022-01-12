package main.java.problem;

import java.util.List;
import java.util.Map;

public class Problem {

    private final List<Cache> caches;
    private final List<Endpoint> endpoints;
    private final List<Request> requests;
    private final List<Video> videos;

    public Problem(List<Cache> caches, List<Endpoint> endpoints, List<Request> requests, List<Video> videos) {
        this.caches = caches;
        this.endpoints = endpoints;
        this.requests = requests;
        this.videos = videos;
    }

    public List<Cache> getCaches() {
        return caches;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public List<Video> getVideos() {
        return videos;
    }
}
