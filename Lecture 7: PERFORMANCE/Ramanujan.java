/**
 * Ramanujan numbers.
 * An integer n is a Ramanujan number if can be expressed as the sum of two positive cubes in two different ways.
 * That is, there are four distinct positive integers a, b, c, and d such that n = a3 + b3 = c3 + d3.
 * For example 1729 = 13 + 123 = 93 + 103.
 */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;

        for (int a = 1; a < Math.cbrt(n); a++) {

            double b = Math.cbrt(n - (a * a * a));

            if (b - Math.floor(b) == 0) {
                count++;
            }
        }
        if (count > 2) return true;
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        System.out.println(isRamanujan(n));
    }
}