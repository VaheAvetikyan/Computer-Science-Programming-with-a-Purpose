/**
 * Generalized harmonic numbers.
 * Write a program that takes two integer command-line arguments n and r
 * and uses a for loop to compute the nth generalized harmonic number of order r,
 * which is defined by the following formula:
 * H(n,r) = 1 / 1^r + 1 / 2^r + ⋯ + 1 / n^r.
 */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double h = 0;

        for (int i = 1; i <= n; i++) {
            double power = Math.pow(i, r);
            h += 1 / power;
        }
        System.out.println(h);
    }
}