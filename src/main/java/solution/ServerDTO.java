package main.java.solution;

import java.util.List;

public class ServerDTO {

    private Integer serverId;
    private List<Integer> videos;

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public List<Integer> getVideos() {
        return videos;
    }

    public void setVideos(List<Integer> videos) {
        this.videos = videos;
    }
}
