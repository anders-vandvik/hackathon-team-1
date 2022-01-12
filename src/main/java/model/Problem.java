package main.java.model;

import java.util.List;

public class Problem {

    private final String id;
    private final List<Cache> caches;
    private final List<Endpoint> endpoints;

    public Problem(String id, List<Cache> caches, List<Endpoint> endpoints) {
        this.id = id;
        this.caches = caches;
        this.endpoints = endpoints;
    }

    public String getId() {
        return id;
    }

    public List<Cache> getCaches() {
        return caches;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

}
