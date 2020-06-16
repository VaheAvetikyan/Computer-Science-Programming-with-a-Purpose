public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;

        int i = 0;
        int j = 0;
        while (Math.abs(i) + Math.abs(j) != r) {
            System.out.println("(" + i + ", " + j + ")");
            steps++;
            double randStep = Math.random();
            if (randStep < 0.25) j--;
            else if (randStep < 0.5) i--;
            else if (randStep < 0.75) j++;
            else i++;
        }
        System.out.println("(" + i + ", " + j + ")");
        System.out.println("steps = " + steps);
    }
}