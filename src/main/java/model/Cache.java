package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private int id;
    private int size;

    private int takenSize;
    private List<Video> videos;

    public Cache(int id, int size) {
        this.id = id;
        this.size = size;
        this.videos = new ArrayList<>();
        this.takenSize = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addVideo(Video video) {
        videos.add(video);
        takenSize += video.getSize();
    }

    public int getRemainingSize() {
        return size - takenSize;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public int getSize() {
        return size;
    }

}
