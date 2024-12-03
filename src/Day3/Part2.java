package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        parseInput("inputs/day3");
    }

    private static void parseInput(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            boolean isEnabled = true;

            Pattern mulPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
            Pattern togglePattern = Pattern.compile("do\\(\\)|don't\\(\\)");
            int totalSum = 0;

            for (String line : lines) {
                Matcher mulMatcher = mulPattern.matcher(line);
                Matcher toggleMatcher = togglePattern.matcher(line);

                boolean mulFound = mulMatcher.find();
                boolean toggleFound = toggleMatcher.find();

                while (mulFound || toggleFound) {
                    if (toggleFound && (!mulFound || toggleMatcher.start() < mulMatcher.start())) {
                        String toggle = toggleMatcher.group();
                        isEnabled = toggle.equals("do()");
                        toggleFound = toggleMatcher.find();
                    } else if (mulFound) {
                        if (isEnabled) {
                            int x = Integer.parseInt(mulMatcher.group(1));
                            int y = Integer.parseInt(mulMatcher.group(2));
                            totalSum += x * y;
                        }
                        mulFound = mulMatcher.find();
                    }
                }
            }

            System.out.println("Answer: " + totalSum);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
