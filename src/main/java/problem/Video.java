package main.java.problem;

public class Video {

    private int videoId;
    private double size;

    public Video(int videoId, double size) {
        this.videoId = videoId;
        this.size = size;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", size=" + size +
                '}';
    }
}
