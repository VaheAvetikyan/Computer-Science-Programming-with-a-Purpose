/**
 * Trinomial coefficients (memoization).
 * Write a program that takes two integer command-line arguments n and k
 * and computes the trinomial coefficient T(n,k) using memoization.
 */

public class TrinomialMemoization {

    private static long[][] trin = new long[100][100];

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        if (k < 0) k = -k;
        if (trin[n][k] != 0) return trin[n][k];
        return trin[n][k] = trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));
    }
}