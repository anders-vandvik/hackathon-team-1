package main.java.solver;

import main.java.model.Cache;
import main.java.model.Video;

import java.util.Random;

public class Node {

    private final Video video;
    private final Cache cache;

    private final long latencyGain;

    private final int timestamp;

    public Node(Video video, Cache cache, long latencyGain) {
        this.video = video;
        this.cache = cache;
        this.timestamp = video.getTimestamp();
        this.latencyGain = latencyGain;
    }

    public boolean isFresh() {
        return timestamp >= video.getTimestamp();
    }

    public Video getVideo() {
        return video;
    }

    public Cache getCache() {
        return cache;
    }

    public int getTimestamp() {
        return timestamp;
    }
    private final Random random = new Random(System.currentTimeMillis());

    public long getLatencyGain() {
        return latencyGain;
    }

    @Override
    public String toString() {
        return "V:" + video.getId() + "->" + "C:" + cache.getId() + ", gain: " + latencyGain;
    }

}
