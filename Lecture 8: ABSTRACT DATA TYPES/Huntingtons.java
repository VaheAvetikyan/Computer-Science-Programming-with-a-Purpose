/**
 * Huntington’s disease detector.
 * Huntington’s disease is an inherited and fatal neurological disorder.
 * Although there is currently no cure, in 1993 scientists discovered a very accurate genetic test.
 * The gene that causes Huntington’s disease is located on chromosome 4
 * and has a variable number of (consecutive) repeats of the CAG trinucleotide.
 * The normal range of CAG repeats is between 10 and 35.
 * Individuals with Huntington’s disease have between 36 and 180 repeats.
 * Doctors can use a PCR-based DNA test;
 * count the maximum number of repeats;
 * and use the following table to generate a diagnosis:
 * repeats  diagnosis
 * 0–9      not human
 * 10–35    normal
 * 36–39    high risk
 * 40–180   Huntington’s
 * 181–     not human
 */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        String cag = "CAG";

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < dna.length(); i++) {
            while ((i + cag.length()) <= dna.length() && cag.equals(dna.substring(i, i + cag.length()))) {
                count++;
                i += cag.length();
            }
            if (count >= maxCount) {
                maxCount = count;
            }
            count = 0;
        }

        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        s = s.replace(" ", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if ((maxRepeats >= 0 && maxRepeats <= 9) || (maxRepeats >= 181)) {
            return "not human";
        } else if (maxRepeats >= 40) {
            return "Huntington's";
        } else if (maxRepeats >= 36) {
            return "high risk";
        }
        return "normal";
    }

    // Sample client.
    public static void main(String[] args) {
        String filename = args[0];

        In file = new In(filename);
        String dna = file.readAll();
        dna = removeWhitespace(dna);
        int maxRe = maxRepeats(dna);

        System.out.println("max repeats = " + maxRe + "\n" + diagnose(maxRe));
    }
}