/**
 * Reve’s puzzle.
 * Reve’s puzzle is identical to the towers of Hanoi problem,
 * except that there are 4 poles (instead of 3).
 * The task is to move n discs of different sizes
 * from the starting pole to the destination pole,
 * while obeying the following rules:
 * Move only one disc at a time.
 * Never place a larger disc on a smaller one.
 */

public class RevesPuzzle {

    private static void revePuzzle(int n, String from, String temp, String temp1, String to) {
        if (n == 0) return;
        int k = (int) (n + 1 - Math.sqrt(2 * n + 1));
        revePuzzle(k, from, to, temp, temp1);
        reveHanoi((n - k), k, from, temp, to);
        revePuzzle(k, temp1, from, temp, to);
    }

    private static void reveHanoi(int n, int k, String from, String temp, String to) {
        if (n == 0) return;
        reveHanoi(n - 1, k, from, to, temp);
        System.out.println("Move disc " + (n + k) + " from " + from + " to " + to);
        reveHanoi(n - 1, k, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        revePuzzle(n, "A", "B", "C", "D");
    }
}