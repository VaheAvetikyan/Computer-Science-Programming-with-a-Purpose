/**
 * Checkerboard.
 * Write a program that takes a command-line integer n and plots an n-by-n checkerboard pattern to standard drawing.
 */

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if ((x + y) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
                }
            }
        }
    }
}