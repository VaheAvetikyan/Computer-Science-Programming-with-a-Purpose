/**
 * Shannon entropy.
 * Write a program that takes a command-line integer m;
 * reads a sequence of integers between 1 and m from standard input;
 * and prints the Shannon entropy to standard output, with 4 digits after the decimal point.
 * The Shannon entropy of a sequence of integers is given by the formula:
 * H = − (p1 log2 p1+p2 log2 p2+…+pm log2 pm)
 * where pi denotes the proportion of integers whose value is i. If pi=0, then treat pi log2 pi as 0.
 * <p>
 * - Compile comand >> javac-introcs ShannonEntropy.java
 * - Run >> java-introcs ShannonEntropy 2 < fair-coin.txt
 * <p>
 * {@code StdIn} is from {@link https://lift.cs.princeton.edu/java/linux/}
 */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        int[] frequency = new int[m];
        double shannonEntropy = 0;
        int count = 0;

        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            frequency[x - 1]++;
            count++;
        }

        for (int i = 0; i < m; i++) {
            if (frequency[i] != 0) {
                shannonEntropy -= ((double) frequency[i] / (double) count) * (Math.log((double) frequency[i] / (double) count) / Math.log(2));
            }
        }

        System.out.printf("%.4f\n", shannonEntropy);
    }
}