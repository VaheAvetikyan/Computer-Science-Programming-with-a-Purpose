/**
 * Inversions.
 * Suppose that a music site wants to compare your song preferences to those of a friend.
 * One approach is to have you and your friend each rank a set of n songs
 * and count the number of pairs of songs (i, j)
 * for which you prefer i to j but your friend prefers j to i.
 * When the count is low, the preferences are similar.
 */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {

        // Guarantees the existence of a permutation of length n with exactly k inversions
        if (k > n * (n - 1) / 2 || n < 0) {
            int[] a = new int[0];
            return a;
            // throw new IllegalArgumentException();
        }

        int[] a = new int[n];

        int j = n - 1;
        int increment = 0;
        for (int i = 0; i < n; i++) {
            if (k - j > 0) {
                a[i] = j;
                k -= j;
                j--;
            } else if (k - j <= 0 && k > 0 && i == n - 1 - k) {
                a[i] = j;
                j++;
            } else {
                a[i] = increment;
                increment++;
            }
        }

        /* Solution with complexity of  O (n ^ 2)
        while (count(a) < k) {
            for (int i = n - 1; i > 0; i--) {
                if (a[i - 1] < a[i]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                    if (count(a) == k) break;
                }
            }
        }
         */

        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] perm = generate(n, k);

        for (int i = 0; i < n; i++) {
            System.out.print(perm[i] + " ");
        }

        System.out.println();
    }
}