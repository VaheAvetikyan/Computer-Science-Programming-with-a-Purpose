/**
 * Audio collage.
 * Create a library to manipulate digital audio and use that library to create an audio collage.
 * Represent sound as an array of real numbers between –1 and +1, with 44,100 samples per second.
 * You will write a library of functions to produce audio effects by manipulating such arrays.
 */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] sample = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            sample[i] = a[i] * alpha;
        }
        return sample;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] sample = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            sample[i] = a[a.length - i - 1];
        }
        return sample;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] sample = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            sample[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            sample[i + a.length] = b[i];
        }
        return sample;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int hi = 0;
        if (a.length >= b.length) {
            hi = a.length;
        } else if (b.length > a.length) {
            hi = b.length;
        }

        double[] sample = new double[hi];

        for (int i = 0; i < hi; i++) {
            if (i < a.length && i < b.length) {
                sample[i] = a[i] + b[i];
            } else if (i >= b.length) {
                sample[i] = a[i];
            } else if (i >= a.length) {
                sample[i] = b[i];
            }
        }
        return sample;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] sample = new double[(int) (a.length / alpha)];
        for (int i = 0; i < (int) (a.length / alpha); i++) {
            sample[i] = a[(int) (i * alpha)];
        }
        return sample;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] exposure = StdAudio.read("exposure.wav");
        double[] singer = StdAudio.read("singer.wav");

        beatbox = amplify(beatbox, 0.3);
        piano = changeSpeed(piano, 0.5);
        exposure = changeSpeed(exposure, 2.0);

        while (beatbox.length < singer.length) {
            beatbox = merge(beatbox, beatbox);
        }
        while (harp.length < singer.length) {
            harp = merge(harp, harp);
        }

        double[] singerReverse = reverse(singer);
        singer = merge(singer, singerReverse);

        while (piano.length < singer.length) {
            piano = merge(piano, piano);
        }

        double[] neo = mix(beatbox, singer);
        neo = mix(neo, harp);
        neo = mix(neo, piano);
        neo = merge(neo, exposure);
        StdAudio.play(neo);
    }
}