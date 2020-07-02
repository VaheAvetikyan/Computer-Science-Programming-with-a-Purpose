/**
 * Trinomial coefficients (brute force).
 * Write a program that takes two integer command-line arguments n and k
 * and computes the corresponding trinomial coefficient.
 * The trinomial coefficient T(n,k) is the coefficient of xn+k in the expansion of (1 + x + x^2)^n.
 */

public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));
    }
}