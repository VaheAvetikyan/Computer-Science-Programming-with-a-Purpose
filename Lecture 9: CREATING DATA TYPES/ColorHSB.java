/**
 * Color data type.
 * Write a data type ColorHSB.java that represents a color in hue–saturation–brightness (HSB) format.
 * The HSB color format is widely used in color pickers.
 */

public class ColorHSB {

    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");

        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + "," + saturation + "," + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (saturation == 0) return true;
        if (brightness == 0) return true;
        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException();
        }
        int distance = (int) (Math.min(Math.pow(hue - that.hue, 2), Math.pow(360 - Math.abs(hue - that.hue), 2))
                + Math.pow(saturation - that.saturation, 2) + Math.pow(brightness - that.brightness, 2));
        return distance;
    }

    // Sample client.
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB referanceColor = new ColorHSB(h, s, b);
        ColorHSB inputColor;
        ColorHSB targetColor = new ColorHSB(0, 0, 0);
        String targetColorName = "";
        int minDistance = Integer.MAX_VALUE;

        while (!StdIn.isEmpty()) {
            String color = StdIn.readString();
            h = StdIn.readInt();
            s = StdIn.readInt();
            b = StdIn.readInt();
            inputColor = new ColorHSB(h, s, b);
            int currentDistance = referanceColor.distanceSquaredTo(inputColor);
            if (currentDistance < minDistance) {
                targetColor = inputColor;
                minDistance = currentDistance;
                targetColorName = color;
            }
        }
        System.out.println(targetColorName + " " + targetColor);
    }
}