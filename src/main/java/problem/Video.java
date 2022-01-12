package main.java.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Video {

    private int id;
    private int size;

    private final Map<Video, List<Endpoint>> videoEndpoints;

    public Video(int id, int size) {
        this.id = id;
        this.size = size;
        this.videoEndpoints = new HashMap<>();
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

    public void add(Video video, Endpoint endpoint) {
        videoEndpoints.computeIfAbsent(video,
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
