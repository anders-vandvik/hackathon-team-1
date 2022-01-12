package main.java.solver;

import main.java.model.*;

import java.util.*;

public class Solver {

    private final List<Cache> caches;
    private final List<Endpoint> endpoints;

    private final long startLatency;
    private final long numRequests;

    private final Map<Video, Map<Cache, List<Endpoint>>> videoCacheEndpoints;

    public Solver(Problem problem) {
        this.caches = problem.getCaches();
        this.endpoints = problem.getEndpoints();
        this.videoCacheEndpoints = buildVideoCacheEndpoints(endpoints);
        this.startLatency = findTotalLatency(endpoints);
        this.numRequests = findNumRequests(endpoints);
    }

    public void solve() {
        long latencyGain = 0;
        PriorityQueue<Node> frontier = buildNodeFrontier();
        while (!frontier.isEmpty()) {
            System.out.println(frontier.size());
            Node node = frontier.poll();
            if (node.getLatencyGain() == 0) break;
            if (node.isFresh()) {
                if (feasible(node)) {
                    assign(node);
                    latencyGain += node.getLatencyGain();
                }
            } else {
                Node newNode = refresh(node);
                frontier.add(newNode);
            }
        }
        System.out.println("obj: " + calcObjective(latencyGain));
    }

    private long calcObjective(long latencyGain) {
        return (1000 * -latencyGain) / numRequests;
    }

    /** Stores the assignment from the node in the solution state. */
    private void assign(Node node) {
        Video video = node.getVideo();
        Cache cache = node.getCache();
        cache.addVideo(video);
        video.incTimestamp();

        for (Endpoint endpoint : getEndpoints(video, cache)) {
            long latencyGain = findLatencyGain(video, cache, endpoint);
            if (latencyGain < 0) {
                endpoint.getRequest(video).setCache(cache);
            }
        }
    }

    /** Creates a new node by reevaluating given assignment. */
    private Node refresh(Node node) {
        Video video = node.getVideo();
        Cache cache = node.getCache();
        long latencyGain = findLatencyGain(video, cache);
        return new Node(video, cache, latencyGain);
    }

    private boolean feasible(Node node) {
        Video video = node.getVideo();
        Cache cache = node.getCache();
        return cache.getRemainingSize() >= video.getSize();
    }

    private PriorityQueue<Node> buildNodeFrontier() {
        PriorityQueue<Node> frontier = initNodeFrontier();
        for (Video video : videoCacheEndpoints.keySet()) {
            for (Cache cache : videoCacheEndpoints.get(video).keySet()) {
                frontier.add(buildNode(video, cache));
            }
        }
        return frontier;
    }

    private Node buildNode(Video video, Cache cache) {
        long latencyGain = findLatencyGain(video, cache);
        return new Node(video, cache, latencyGain);
    }

    /** Returns how much the latency will change after a given assignemtn. */
    private long findLatencyGain(Video video, Cache cache) {
        long latencyGain = 0;
        for (Endpoint endpoint : getEndpoints(video, cache)) {
            latencyGain += findLatencyGain(video, cache, endpoint);
        }
        return latencyGain;
    }

    /** Returns how much the latency will change for a given endpoint when the video is put on the cache. */
    private long findLatencyGain(Video video, Cache cache, Endpoint endpoint) {
        long currentLatency = endpoint.getLatency(video);

        long cacheLatency = endpoint.getCacheLatency(cache);
        Request request = endpoint.getRequest(video);
        long newLatency = cacheLatency * request.getNumberOfRequests();

        return Math.min(0, newLatency - currentLatency);
    }

    private List<Endpoint> getEndpoints(Video video, Cache cache) {
        return videoCacheEndpoints.get(video).get(cache);
    }

    /** Finds the total latency of the problem.*/
    private static long findTotalLatency(List<Endpoint> endpoints) {
        long latency = 0;
        for (Endpoint endpoint : endpoints) {
            latency += findLatency(endpoint);
        }
        return latency;
    }

    /** Finds the total latency of the given endpoint. */
    private static long findLatency(Endpoint endpoint) {
        long latency = 0;
        for (Video video : endpoint.getVideos()) {
            latency += endpoint.getLatency(video);
        }
        return latency;
    }

    private static long findNumRequests(List<Endpoint> endpoints) {
        long numRequests = 0;
        for (Endpoint endpoint : endpoints) {
            for (Request request : endpoint.getRequests()) {
                numRequests += request.getNumberOfRequests();
            }
        }
        return numRequests;
    }

    /** Builds a mapping from videos to caches to endpoints that have access to the cache and request a video. */
    private static Map<Video, Map<Cache, List<Endpoint>>> buildVideoCacheEndpoints(List<Endpoint> endpoints) {
        Map<Video, Map<Cache, List<Endpoint>>> videoCacheEndpoints = new HashMap<>();

        for (Endpoint endpoint : endpoints) {
            Set<Video> videos = endpoint.getVideos();
            Set<Cache> caches = endpoint.getCaches();
            for (Video video : videos) {
                Map<Cache, List<Endpoint>> cacheEndpoints =
                        videoCacheEndpoints.computeIfAbsent(video, k -> new HashMap<>());
                for (Cache cache : caches) {
                    cacheEndpoints.computeIfAbsent(cache,
                            k -> new ArrayList<>()).add(endpoint);
                }
            }
        }
        return videoCacheEndpoints;
    }

    private static PriorityQueue<Node> initNodeFrontier() {
        return new PriorityQueue<>((node1, node2) -> {
            long f = node1.getLatencyGain() - node2.getLatencyGain();
            if (f != 0) return (int)f;
            int n = node1.getCache().getId() - node2.getCache().getId();
            if (n != 0) return n;
            return node1.getVideo().getId() - node2.getVideo().getId();
        });
    }

}
