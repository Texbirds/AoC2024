package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        String filePath = "inputs/day4";
        String word = "XMAS";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            String[] grid = lines.toArray(new String[0]);

            int result = countWordOccurrences(grid, word);
            System.out.println("Occurrences of " + word + ": " + result);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static int countWordOccurrences(String[] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length();
        int[][] directions = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int[] direction : directions) {
                    int dx = direction[0];
                    int dy = direction[1];
                    if (matchesWord(grid, row, col, dx, dy, word, rows, cols)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean matchesWord(String[] grid, int row, int col, int dx, int dy, String word, int rows, int cols) {
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            int newRow = row + i * dx;
            int newCol = col + i * dy;

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                return false;
            }

            if (grid[newRow].charAt(newCol) != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
