package main.java.solution;

import java.util.List;

public class SolutionDTO {

    private String id;
    private List<ServerDTO> serverList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ServerDTO> getServerList() {
        return serverList;
    }

    public void setServerList(List<ServerDTO> serverList) {
        this.serverList = serverList;
    }
}
