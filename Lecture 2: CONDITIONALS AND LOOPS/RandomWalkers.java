/**
 * Random walkers.
 * Write a program that takes two integer command-line arguments r and trials.
 * In each of trials independent experiments, simulate a random walk until
 * the random walker is at Manhattan distance r from the starting point.
 * Print the average number of steps.
 */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int steps = 0;

        for (int n = 0; n < trials; n++) {
            int i = 0;
            int j = 0;
            while (Math.abs(i) + Math.abs(j) != r) {
                steps++;
                double randStep = Math.random();
                if (randStep < 0.25) j--;
                else if (randStep < 0.5) i--;
                else if (randStep < 0.75) j++;
                else i++;
            }
        }
        double avarage = (double) steps / (double) trials;
        System.out.println("average number of steps = " + avarage);
    }
}