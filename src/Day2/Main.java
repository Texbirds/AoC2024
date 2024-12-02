package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static ArrayList<String> firstList = new ArrayList<>();
    static ArrayList<String> secondList = new ArrayList<>();

    public static void main(String[] args) {

        parseInput("inputs/day2", firstList, secondList);

        System.out.println(firstList.size());
    }

    private static void parseInput(String filePath, ArrayList<String> firstList, ArrayList<String> secondList) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                ArrayList<Integer> numbers = new ArrayList<>();
                ArrayList<Integer> backup = new ArrayList<>();
                boolean safeBuffer = false;

                String[] split = line.trim().split(" ");
                for (String s : split) {
                    numbers.add(Integer.parseInt(s));
                    backup.add(Integer.parseInt(s));
                }

                for (int i = 0; i <= numbers.size(); i++) {
                    ArrayList<Integer> newArray;

                    if (i == numbers.size()) {
                        newArray = new ArrayList<>(backup);
                    } else {
                        newArray = new ArrayList<>(backup);
                        newArray.remove(i);
                    }

                    if (safetyChecker(newArray)) {
                        safeBuffer = true;
                    }
                }

                if (safeBuffer) {
                    firstList.add(line);
                } else {
                    secondList.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static boolean safetyChecker(ArrayList<Integer> numbers) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            int previous = numbers.get(i - 1);
            int diff = current - previous;

            if (Math.abs(diff) > 3 || diff == 0) {
                return false;
            }

            if (diff > 0) {
                decreasing = false;
            } else if (diff < 0) {
                increasing = false;
            }
        }

        return increasing || decreasing;
    }
}
