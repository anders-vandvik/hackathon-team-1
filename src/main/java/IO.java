package main.java;

import main.java.problem.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IO {

    public Problem readFile(String problemFile) {
        InputStream inputStream = IO.class.getResourceAsStream(problemFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Problem();
    }


}
