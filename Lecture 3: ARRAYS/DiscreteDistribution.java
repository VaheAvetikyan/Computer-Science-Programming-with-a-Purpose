/**
 * Discrete distribution.
 * Write a program DiscreteDistribution.java that takes an integer command-line argument m,
 * followed by a sequence of positive integer command-line arguments a1,a2,…,an,
 * and prints m random indices (separated by whitespace),
 * choosing each index i with probability proportional to ai.
 */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int n = args.length;

        // m is the number of trials
        int m = Integer.parseInt(args[0]);

        // s is the array of intervals
        int[] s = new int[n];
        s[0] = 0;

        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + Integer.parseInt(args[i]);
        }

        for (int j = 0; j < m; j++) {
            int r = (int) (Math.random() * (s[n - 1] - 1));

            // A solution with Binary Search
            int lo = 0;
            int hi = n;
            int mid;

            while (hi >= lo) {
                mid = lo + (hi - lo) / 2;

                if (r >= s[mid - 1] && r < s[mid]) {
                    System.out.print(mid + " ");
                    break;
                } else if (r >= s[mid]) {
                    lo = mid;
                } else if (r < s[mid - 1]) {
                    hi = mid;
                }
            }

            /*  A solution with linear search
            for (int i = 1; i < n; i++) {
                if (r >= s[i - 1] && r < s[i]) {
                    System.out.print(i + " ");
                }
            }
            */
        }
        System.out.println();
    }
}