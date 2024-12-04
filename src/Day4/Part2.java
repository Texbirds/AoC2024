package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        String filePath = "inputs/day4";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            String[] grid = lines.toArray(new String[0]);

            int result = countXMASPatterns(grid);
            System.out.println(result);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countXMASPatterns(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int count = 0;

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                if (isXMAS(grid, row, col)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isXMAS(String[] grid, int row, int col) {
        boolean topLeftBottomRight = isMAS(grid[row - 1].charAt(col - 1), grid[row].charAt(col), grid[row + 1].charAt(col + 1));
        boolean bottomRightTopLeft = isMAS(grid[row + 1].charAt(col - 1), grid[row].charAt(col), grid[row - 1].charAt(col + 1));

        return topLeftBottomRight && bottomRightTopLeft;
    }

    private static boolean isMAS(char m, char a, char s) {
        return (m == 'M' && a == 'A' && s == 'S') || (m == 'S' && a == 'A' && s == 'M');
    }
}
