/**
 * Minesweeper is a 1960s era video game played on an m-by-n grid of cells.
 * The goal is to deduce which cells contain hidden mines using clues about the number of mines in neighboring cells.
 * Write a program Minesweeper.java that takes three integer command-line arguments m, n, and k
 * and prints an m-by-n grid of cells with k mines,
 * using asterisks for mines and integers for the neighboring mine counts.
 * To do so,
 * - Generate an m-by-n grid of cells, with exactly k of the mn cells containing mines, uniformly at random.
 * - For each cell not containing a mine, count the number of neighboring mines (above, below, left, right, or diagonal).
 */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] grid = new int[m][n];

        // Generate the coordinates of mines in the array
        while (k > 0) {
            int a = (int) (Math.random() * m), b = (int) (Math.random() * n);
            if (grid[a][b] == 0) {
                grid[a][b] = -1;
                k--;
            }
        }

        // Increase the number of neighboring mines
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    for (int a = -1; a < 2; a++) {
                        if (i + a >= 0 && i + a < m) {
                            for (int b = -1; b < 2; b++) {
                                if (j + b >= 0 && j + b < n && grid[i + a][j + b] >= 0) {
                                    grid[i + a][j + b]++;
                                }
                            }
                        }
                    }
                }
            }
        }

        // Print the grid
        for (
                int i = 0;
                i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] >= 0) System.out.print(grid[i][j] + "  ");
                else System.out.print("*  ");
            }
            System.out.println();
        }
    }
}