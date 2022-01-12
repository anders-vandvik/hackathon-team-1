package main.java.model;

import java.util.List;

public class Problem {

    private final List<Cache> caches;
    private final List<Endpoint> endpoints;

    public Problem(List<Cache> caches, List<Endpoint> endpoints) {
        this.caches = caches;
        this.endpoints = endpoints;
    }

    public List<Cache> getCaches() {
        return caches;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

}
