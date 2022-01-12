package main.java.problem;

public class Request {

    private int requestId;
    private int videoId;
    private int endpointId;
    private double numberOfRequests;

    public Request(int requestId, int videoId, int endpointId, double numberOfRequests) {
        this.requestId = requestId;
        this.videoId = videoId;
        this.endpointId = endpointId;
        this.numberOfRequests = numberOfRequests;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getEndpointId() {
        return endpointId;
    }

    public void setEndpointId(int endpointId) {
        this.endpointId = endpointId;
    }

    public double getNumberOfRequests() {
        return numberOfRequests;
    }

    public void setNumberOfRequests(double numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", videoId=" + videoId +
                ", endpointId=" + endpointId +
                ", numberOfRequests=" + numberOfRequests +
                '}';
    }
}
