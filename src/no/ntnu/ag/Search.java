package no.ntnu.ag.src;

/**
 * Deprecated
 * 
 * Wrapper for useful methods related to searching.
 */
public class Search {
    /**
     * Returns a mesure of how similar two strings are.
     * The value ranges from 0 to 1.
     * 0 being no match and 1 being a perfect match.
     * <p>
     * This method uses an algorithm inspired by
     * the Sørensen–Dice coefficient algorithm.
     * @param x The first String to compare.
     * @param y The second String to compare.
     * @return The similarity of the two Strings as a Double[0,1];
     * @author Håkon Lervik
     * @version 0.4
     */
    public static double similarity(String x, String y) {
        String xString = " " + x.toLowerCase() + " ";
        String yString = " " + y.toLowerCase() + " ";
        int xLen = x.length();
        int yLen = y.length();
        String[] xBigrams = new String[xLen+1];
        String[] yBigrams = new String[yLen+1];

        for (int i = 0; i <= xLen; i++) {
            xBigrams[i] = xString.substring(i, i+2);
        }
        for (int i = 0; i <= yLen; i++) {
            yBigrams[i] = yString.substring(i, i+2);
        }

        double matches = 0;
        for (int i = 0; i <= xLen; i++) {
            for (int j = 0; j <= yLen; j++) {
                if (xBigrams[i].equals(yBigrams[j])) matches++;
            }
        }

        return 2*matches/(double)(xLen+yLen);
    }
}