/**
 * World maps.
 * Write a program that reads boundary information of a country (or other geographic entity)
 * from standard input and plots the results to standard drawing.
 * A country consists of a set of regions (e.g., states, provinces, or other administrative divisions),
 * each of which is described by a polygon.
 */

public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            StdIn.readString();

            int vertices = StdIn.readInt();
            double[] x = new double[vertices];
            double[] y = new double[vertices];

            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}