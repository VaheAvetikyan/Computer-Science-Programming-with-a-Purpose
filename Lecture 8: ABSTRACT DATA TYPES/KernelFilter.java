/**
 * Kernel filter.
 * Write an image-processing library KernelFilter.java that applies various kernel filters to images,
 * such as Gaussian blur, sharpen, Laplacian, emboss, and motion blur.
 * A kernel filter modifies the pixels in an image
 * by replacing each pixel with a linear combination of its neighboring pixels.
 * The matrix that characterizes the linear combination is known as the kernel.
 */

import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] kernelFilterMatrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        Picture target = applyKernelFilter(picture, kernelFilterMatrix);

        return target;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double gaussianBlurFactor = 16;
        double[][] kernelFilterMatrix = {
                {1 / gaussianBlurFactor, 2 / gaussianBlurFactor, 1 / gaussianBlurFactor},
                {2 / gaussianBlurFactor, 4 / gaussianBlurFactor, 2 / gaussianBlurFactor},
                {1 / gaussianBlurFactor, 2 / gaussianBlurFactor, 1 / gaussianBlurFactor}
        };

        Picture target = applyKernelFilter(picture, kernelFilterMatrix);
        return target;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] kernelFilterMatrix = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};

        Picture target = applyKernelFilter(picture, kernelFilterMatrix);
        return target;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] kernelFilterMatrix = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};

        Picture target = applyKernelFilter(picture, kernelFilterMatrix);
        return target;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] kernelFilterMatrix = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};

        Picture target = applyKernelFilter(picture, kernelFilterMatrix);
        return target;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int n = 9;
        double[][] kernelFilterMatrix = new double[n][n];
        double motionBlurFactor = n;
        for (int i = 0; i < kernelFilterMatrix.length; i++) {
            kernelFilterMatrix[i][i] = 1 / motionBlurFactor;
        }

        Picture target = applyKernelFilter(picture, kernelFilterMatrix);
        return target;
    }

    // Returns a new picture that applies an arbitrary Kernel filter to the given picture.
    private static Picture applyKernelFilter(Picture picture, double[][] weights) {
        Picture target = new Picture(picture.width(), picture.height());

        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                Color targetPixel = applyKernelPixel(picture, weights, i, j);
                target.set(i, j, targetPixel);
            }
        }
        return target;
    }

    private static Color applyKernelPixel(Picture picture, double[][] weights, int i, int j) {
        int width, height;
        double red = 0;
        double green = 0;
        double blue = 0;

        for (int n = -weights.length / 2; n <= weights.length / 2; n++) {
            if (i + n < 0) width = (picture.width() + (i + n)) % picture.width();
            else width = (i + n) % picture.width();

            for (int m = -weights.length / 2; m <= weights.length / 2; m++) {
                if (j + m < 0) height = (picture.height() + (j + m)) % picture.height();
                else height = (j + m) % picture.height();

                Color c = picture.get(width, height);
                red += c.getRed() * weights[n + weights.length / 2][m + weights.length / 2];
                green += c.getGreen() * weights[n + weights.length / 2][m + weights.length / 2];
                blue += c.getBlue() * weights[n + weights.length / 2][m + weights.length / 2];
            }
        }
        return new Color(normalizeRGBColor(red), normalizeRGBColor(green), normalizeRGBColor(blue));
    }

    // Normolizing color numbers
    private static int normalizeRGBColor(double col) {
        int color = (int) Math.round(col);
        if (color > 255) return 255;
        else if (color < 0) return 0;
        return color;
    }

    // Test client.
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        Picture pic1 = identity(pic);
        pic1.show();
        Picture pic2 = gaussian(pic);
        pic2.show();
        Picture pic3 = sharpen(pic);
        pic3.show();
        Picture pic4 = laplacian(pic);
        pic4.show();
        Picture pic5 = emboss(pic);
        pic5.show();
        Picture pic6 = motionBlur(pic);
        pic6.show();
    }
}