package main.java.problem;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private int cacheId;
    private int numberOfConnectedEndpoints;

    private List<Video> videos;

    public Cache(int cacheId) {
        this.cacheId = cacheId;
        this.videos = new ArrayList<>();
    }

    public Cache(int cacheId, int numberOfConnectedEndpoints, List<Integer> endpointIds) {
        this.cacheId = cacheId;
        this.numberOfConnectedEndpoints = numberOfConnectedEndpoints;
        this.videos = new ArrayList<>();
    }

    public int getCacheId() {
        return cacheId;
    }

    public void setCacheId(int cacheId) {
        this.cacheId = cacheId;
    }

    public int getNumberOfConnectedEndpoints() {
        return numberOfConnectedEndpoints;
    }

    public void incrementNumberOfConnectedEndpoints() {
        this.numberOfConnectedEndpoints++;
    }

    public void setNumberOfConnectedEndpoints(int numberOfConnectedEndpoints) {
        this.numberOfConnectedEndpoints = numberOfConnectedEndpoints;
    }

    public void addVideo(Video video) {
        this.videos.add(video);
    }

    public List<Video> getVideos() {
        return videos;
    }
}
