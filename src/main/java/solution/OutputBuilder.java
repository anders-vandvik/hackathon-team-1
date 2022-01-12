package main.java.solution;

import main.java.model.Cache;
import main.java.model.Problem;
import main.java.model.Video;

import java.util.ArrayList;
import java.util.List;

public class OutputBuilder {

    private final String name;
    private final Problem[] problems;

    public OutputBuilder(String name, Problem... problems) {
        this.name = name;
        this.problems = problems;
    }

    public OutputDTO build() {
        OutputDTO output = new OutputDTO();
        output.setName(name);

        List<SolutionDTO> solutions = new ArrayList<>();
        output.setSolutions(solutions);

        for (Problem problem : problems) {
            solutions.add(buildSolution(problem));
        }

        return output;
    }

    private SolutionDTO buildSolution(Problem problem) {
        SolutionDTO solution = new SolutionDTO();
        solution.setId(problem.getId());

        List<ServerDTO> servers = new ArrayList<>();
        solution.setServerList(servers);

        for (Cache cache : problem.getCaches()) {
            ServerDTO server = new ServerDTO();
            server.setServerId(cache.getId());
            servers.add(server);

            List<Integer> videoIds = new ArrayList<>();
            server.setVideos(videoIds);

            for (Video video : cache.getVideos()) {
                videoIds.add(video.getId());
            }
        }

        return solution;
    }

}
