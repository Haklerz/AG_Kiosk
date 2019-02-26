package no.ntnu.ag.src;

public class StringSimilarity {
    public static double Coefficiant(String x, String y) {
        double similarity;
        int xLength = x.length();
        int yLength = y.length();
        //If eather String is of length 0;
        if (xLength + yLength <= 1) {
            similarity = 0;
        }
        //If both Strings are of length 1;
        else if (xLength == 1 && yLength == 1) {
            similarity = (x.equals(y)) ? 1 : 0;
        }
        //If eather String is longer than 1;
        else {
            String[] xBigrams = new String[xLength-1];
            String[] yBigrams = new String[yLength-1];
            for (int i = 0; i < xLength-1; i++) {
                xBigrams[i] = x.substring(i, i+2);
            }
            for (int i = 0; i < yLength-1; i++) {
                yBigrams[i] = y.substring(i, i+2);
            }

            similarity = 0.5;
        }

        return similarity;
    }
}