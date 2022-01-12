package main.java.model;

public class Request {

    private final int numberOfRequests;
    private Cache cache;

    public Request(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
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
                ", numberOfRequests=" + numberOfRequests +
                '}';
    }
}
