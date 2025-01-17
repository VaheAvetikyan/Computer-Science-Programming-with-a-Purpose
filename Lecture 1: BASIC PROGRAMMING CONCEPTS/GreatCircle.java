/**
 * The great-circle distance is the length of the shortest path between two points (x1,y1) and (x2,y2)
 * on the surface of a sphere, where the path is constrained to be along the surface.
 */

public class GreatCircle {
    public static void main(String[] args) {
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        final double r = 6371.0;

        double distance = 2 * r * Math.asin(Math.sqrt(Math.sin((x2 - x1) / 2.0) * Math.sin((x2 - x1) / 2.0)
                + Math.cos(x1) * Math.cos(x2) * Math.sin((y2 - y1) / 2.0) * Math.sin((y2 - y1) / 2.0)));

        System.out.println(distance + " kilometers");
    }
}
