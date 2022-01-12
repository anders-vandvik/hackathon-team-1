package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private int id;
    private int size;

    private List<Video> videos;

    public Cache(int id, int size) {
        this.id = id;
        this.size = size;
        this.videos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addVideo(Video video) {
        this.videos.add(video);
    }

    public List<Video> getVideos() {
        return videos;
    }

    public int getSize() {
        return size;
    }

}
