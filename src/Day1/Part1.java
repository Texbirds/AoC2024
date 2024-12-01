package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Part1 {

    public static void main(String[] args) {
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        parseInput("inputs/day1", firstList, secondList);

        Collections.sort(firstList);
        Collections.sort(secondList);

//        doPartOne(firstList, secondList);
        doPartTwo(firstList, secondList);
    }

    public static void doPartOne(List<Integer> firstList, List<Integer> secondList) {
        System.out.println(calculateDistance((ArrayList<Integer>) firstList, (ArrayList<Integer>) secondList));
    }

    public static void doPartTwo(List<Integer> firstList, List<Integer> secondList) {
        System.out.println(calculateSimilarity((ArrayList<Integer>) firstList, (ArrayList<Integer>) secondList));
    }

    private static void parseInput(String filePath, ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] split = line.trim().split("\\s+");
                firstList.add(Integer.parseInt(split[0]));
                secondList.add(Integer.parseInt(split[1]));
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static int calculateDistance(ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
        int totalDistance = 0;

        for (int i = 0; i < firstList.size(); i++) {
            totalDistance += Math.abs(firstList.get(i) - secondList.get(i));
        }
        return totalDistance;
    }

    private static int calculateSimilarity(ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
        int totalSimilarity = 0;
        int j = 0;


        for (int i = 0; i < firstList.size(); i++) {
            int counter = 0;

             while (j < secondList.size() && firstList.get(i) >= secondList.get(j)) {
                if (firstList.get(i).equals(secondList.get(j))) {
                    counter++;
                }
                j++;
            }

            totalSimilarity += (firstList.get(i) * counter);
        }

        return totalSimilarity;
    }
}
