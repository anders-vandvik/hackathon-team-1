package main.java.model;

public class Video {

    private int id;
    private int size;

    private int timestamp;

    public Video(int id, int size) {
        this.id = id;
        this.size = size;
        this.timestamp = 0;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void incTimestamp() {
        timestamp++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + id +
                ", size=" + size +
                '}';
    }
}
