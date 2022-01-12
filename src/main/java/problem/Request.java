package main.java.problem;

public class Request {

    private final int id;
    private final double numberOfRequests;
    private final Video video;

    private Cache cache;

    public Request(int requestId, int numberOfRequests, Video video) {
        this.id = requestId;
        this.numberOfRequests = numberOfRequests;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public double getNumberOfRequests() {
        return numberOfRequests;
    }

    public Video getVideo() {
        return video;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + id +
                ", videoId=" + video.getId() +
                ", numberOfRequests=" + numberOfRequests +
                '}';
    }
}
