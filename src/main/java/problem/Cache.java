package main.java.problem;

import java.util.List;

public class Cache {

    private int cacheId;
    private int numberOfConnectedEndpoints;
    private List<Integer> endpointIds;

    public Cache(int cacheId) {
        this.cacheId = cacheId;
    }

    public Cache(int cacheId, int numberOfConnectedEndpoints, List<Integer> endpointIds) {
        this.cacheId = cacheId;
        this.numberOfConnectedEndpoints = numberOfConnectedEndpoints;
        this.endpointIds = endpointIds;
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

    public List<Integer> getEndpointIds() {
        return endpointIds;
    }

    public void addEndpoint(int endpointId) {
        this.incrementNumberOfConnectedEndpoints();
        this.endpointIds.add(endpointId);
    }

    public void setEndpointIds(List<Integer> endpointIds) {
        this.endpointIds = endpointIds;
    }
}
