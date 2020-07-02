/**
 * Trinomial coefficients (dynamic programming).
 * Write a program that takes two integer command-line arguments n and k
 * and computes the trinomial coefficient T(n,k) using dynamic programming.
 */

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < 0) k = -k;
        long[][] TDP = new long[n * 2 + 1][k * 2 + 2];
        for (int i = n; i <= n * 2; i++) {
            for (int j = k; j <= Math.min(i, k * 2); j++) {
                if (i == n && j == k) {
                    TDP[i][j] = 1;
                    continue;
                }
                if (j < -i || j > i) {
                    TDP[i][j] = 0;
                    continue;
                }
                if (j == 0) {
                    TDP[i][j] = TDP[i - 1][j + 1] + TDP[i - 1][j] + TDP[i - 1][j + 1];
                } else {
                    TDP[i][j] = TDP[i - 1][j - 1] + TDP[i - 1][j] + TDP[i - 1][j + 1];
                }
            }
        }
        return TDP[n * 2][k * 2];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));
    }
}