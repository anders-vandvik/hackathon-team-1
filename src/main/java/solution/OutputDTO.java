package main.java.solution;

import java.util.List;

public class OutputDTO {

    private String name;
    private List<SolutionDTO> solutions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SolutionDTO> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<SolutionDTO> solutions) {
        this.solutions = solutions;
    }
}
