package main.java.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Video {

    private int id;
    private int size;

    private final Map<Cache, List<Endpoint>> cacheEndpoints;

    public Video(int id, int size) {
        this.id = id;
        this.size = size;
        this.cacheEndpoints = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Endpoint> getEndpoints(Cache cache) {
        return cacheEndpoints.get(cache);
    }

    public void add(Cache cache, Endpoint endpoint) {
        cacheEndpoints.computeIfAbsent(cache,
                k-> new ArrayList<>()).add(endpoint);
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + id +
                ", size=" + size +
                '}';
    }
}
