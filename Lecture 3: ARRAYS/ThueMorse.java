/**
 * Thue–Morse weave.
 * Write a program that takes an integer command-line argument n
 * and prints an n-by-n pattern like the ones below.
 * Include two space characters between each + and - character.
 */

public class ThueMorse {
    public static void main(String[] args) {
        // Get the smallest power of 2 larger than provided argument
        int temp = Integer.parseInt(args[0]);
        int n = 0;
        int power = 0;
        while (Math.pow(2, power - 1) <= temp) {
            n = (int) Math.pow(2, power);
            if (n == temp && temp != 1) break;
            power++;
        }

        // Create Thue–Morse sequence
        boolean[] thueMorse = new boolean[n];
        thueMorse[0] = false;
        int pow = 0;
        for (int i = 1; pow < n; i++) {
            pow = (int) Math.pow(2, i);
            for (int j = 0; j < pow / 2; j++) {
                thueMorse[pow / 2 + j] = !thueMorse[j];
            }
        }

        for (int i = 0; i < temp; i++) {
            for (int j = 0; j < temp; j++) {
                if (thueMorse[i] == thueMorse[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }
    }
}