package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        parseInput("inputs/day3");
    }

    private static void parseInput(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
            int totalSum = 0;

            for (String line : lines) {
                String corruptMemory = line;
                Matcher matcher = pattern.matcher(corruptMemory);

                while (matcher.find()) {
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    totalSum += x * y;
                }
            }

            System.out.println("Answer: " + totalSum);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
