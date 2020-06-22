/**
 * Random walk.
 * A Java programmer begins walking aimlessly.
 * At each time step, she takes one step in a random direction (either north, east, south, or west),
 * each with probability 25%. She stops once she is at Manhattan distance r from the starting point.
 * How many steps will the random walker take? This process is known as a two-dimensional random walk.
 */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;

        int i = 0;
        int j = 0;
        while (Math.abs(i) + Math.abs(j) != r) {
            System.out.println("(" + i + ", " + j + ")");
            steps++;
            double randStep = Math.random();
            if (randStep < 0.25) j--;
            else if (randStep < 0.5) i--;
            else if (randStep < 0.75) j++;
            else i++;
        }
        System.out.println("(" + i + ", " + j + ")");
        System.out.println("steps = " + steps);
    }
}