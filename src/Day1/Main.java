package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Read the input file
            List<String> lines = Files.readAllLines(Paths.get("inputs/day1"));

            // Process the input
            for (String line : lines) {
                System.out.println(line); // Print each line (or process as needed)
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
