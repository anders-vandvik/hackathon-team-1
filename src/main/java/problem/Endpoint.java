package main.java.problem;

import java.util.Map;

public class Endpoint {

    private int endpointId;
    private double latencyDataCenter;
    private int numberOfConnectedCaches;
    private Map<Integer, Double> cacheIdToLatency;

    public Endpoint(int endpointId, double latencyDataCenter, int numberOfConnectedCaches, Map<Integer, Double> cacheIdToLatency) {
        this.endpointId = endpointId;
        this.latencyDataCenter = latencyDataCenter;
        this.numberOfConnectedCaches = numberOfConnectedCaches;
        this.cacheIdToLatency = cacheIdToLatency;
    }

    public int getEndpointId() {
        return endpointId;
    }

    public void setEndpointId(int endpointId) {
        this.endpointId = endpointId;
    }

    public double getLatencyDataCenter() {
        return latencyDataCenter;
    }

    public void setLatencyDataCenter(double latencyDataCenter) {
        this.latencyDataCenter = latencyDataCenter;
    }

    public int getNumberOfConnectedCaches() {
        return numberOfConnectedCaches;
    }

    public void setNumberOfConnectedCaches(int numberOfConnectedCaches) {
        this.numberOfConnectedCaches = numberOfConnectedCaches;
    }

    public Map<Integer, Double> getCacheIdToLatency() {
        return cacheIdToLatency;
    }

    public void setCacheIdToLatency(Map<Integer, Double> cacheIdToLatency) {
        this.cacheIdToLatency = cacheIdToLatency;
    }
}
