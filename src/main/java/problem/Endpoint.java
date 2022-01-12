package main.java.problem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Endpoint {

    private final int id;
    private final int latencyDataCenter;

    private final Map<Cache, Integer> cacheLatencies;
    private final Map<Video, Request> videoRequests;

    public Endpoint(int id, int latencyDataCenter) {
        this.id = id;
        this.latencyDataCenter = latencyDataCenter;
        this.cacheLatencies = new HashMap<>();
        this.videoRequests = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public double getLatencyDataCenter() {
        return latencyDataCenter;
    }

    public Integer getCacheLatency(Cache cache) {
        return cacheLatencies.get(cache);
    }

    public Collection<Request> getRequests( ){
        return videoRequests.values();
    }

    ///////
    public void addCacheLatency(Cache cache, int latency) {
        cacheLatencies.put(cache, latency);
    }

    @Override
    public String toString() {
        return "Endpoint{" +
                "endpointId=" + id +
                ", latencyDataCenter=" + latencyDataCenter +
                ", numberOfConnectedCaches=" + cacheLatencies.size() +
                '}';
    }
}
