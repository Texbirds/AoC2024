package Template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Template {
    public static void main(String[] args) {
        parseInput("inputs/day3");
    }

    private static void parseInput(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {

            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
